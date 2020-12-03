package Control;

import DAO.SolicitudDAO;
import Entidad.Solicitud;
import Entidad.Correo;
import Entidad.Usuario;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;

public class Validar_administrar_solicitud {

    private ManipularConecciones conexion = null;

    public Validar_administrar_solicitud(ManipularConecciones conexion) {
        this.conexion = conexion;
        solicitud = new SolicitudDAO(conexion.getConeccion());
    }

    private SolicitudDAO solicitud;

    public String[][] llenarMatriz(Usuario par, String tipo_e) throws SQLException {
        return solicitud.leerSolicitudes(par, convertirTipo_e(tipo_e));
    }

    public String[] datos_solicitud(Usuario par, int id_sol) {
        return solicitud.leerunaSolicitud(par, id_sol);
    }

    public String dias_sol(Usuario par, int id_sol) {
        return solicitud.leerdias_soli(par, id_sol);
    }

    private int convertirTipo_e(String estado) {
        if (estado.equals("Aceptada")) {
            return 1;
        } else if (estado.equals("Espera")) {
            return 2;
        } else if (estado.equals("Rechazada")) {
            return 3;
        } else if (estado.equals("Cancelada")) {
            return 4;
        } else {
            return 0;
        }
    }

    public int cambiarEstado(Usuario par, String tipo_e, String id_solicitud, String Observacion, String tipeA) {

        int tipoE = convertirTipo_e(tipo_e);
        int tipoEA = convertirTipo_e(tipeA);
        if (tipoE == tipoEA) {
            return -5;
        } else if (tipoE == 3 && tipoEA == 1) {
            return -5;
        } else if (tipoE == 4 && tipoEA == 3) {
            return -5;
        } else if ((tipoE == 1 || tipoE == 3) && tipoEA == 4) {
            return -5;
        } else if (tipoE == 1) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else if (tipoE == 3) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else if (tipoE == 4) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else {
            return -1;
        }

    }

    public boolean verificarEnvio(String contrasenia, String id, String tipE, String correoU, String obs) throws AddressException, Exception {

        Correo correo = new Correo();
        correo.setAsunto("Respuesta a su solicitud con ID: " + id);
        correo.setMensaje("Estimado/a <b>Usuario</b>,<br> Queremos informale que su solicitud con id: " + id
                + "Ha cambiado al estado:<b> " + tipE + "</b>. A continuación se muestra la observación indicada por el coordinador:<br>" + obs + "<br>Muchas gracias por su atención.<br>Por favor, no responder a este correo.");
        correo.setCorreoReceptor(correoU + "@unal.edu.co");
        EnviarCorreo enviarCorreo = new EnviarCorreo();
        enviarCorreo.setManipularConexion(conexion);
        return enviarCorreo.enviarC(correo);
    }

    public String[] obtenerListaMotivos(Usuario par) {
        return solicitud.obtenerMotivo(par);
    }

    public String verificarDatosSolicitudNueva(Usuario par, Solicitud sol, String motivo, String motivoOtro, String fechaTermina, String fechaEmpieza, int horaInicio, int MinutosInicio, int horaFinal, int MinutosFinal, String estadoEspacio) {

        String validacionFecha = verificarFechaActual(par, fechaTermina, fechaEmpieza);
        String validacionHoras = verificarHorasMinutosIngresadas(horaInicio, MinutosInicio, horaFinal, MinutosFinal);
        String valicacionMotivoSolicitud = verificarMotivoSolicitud(motivo, motivoOtro);
        String verificacionConcurrencia = (verificarCruceEventos(par, sol)) ? "El evento se puede registrar" : "<tr><td>Un evento ya aceptado se cruza con este o no seleccionó ningún espacio donde hacer la solicitud</td></tr>";
        String verificarEstadoActivo = verificarEstadoEspacio(estadoEspacio);

        if ("Motivo ingresado correctamente".equals(valicacionMotivoSolicitud)
                && "La fecha es valida".equals(validacionFecha)
                && "Las horas están correctas".equals(validacionHoras)
                && "El evento se puede registrar".equals(verificacionConcurrencia)
                && "ok".equals(verificarEstadoActivo)) {

            String ingreso_bd = ingresarSolicitudNueva(par, sol);

            if ("Ingreso completo".equals(ingreso_bd)) {
                return "ok";
            } else {
                return ingreso_bd;
            }

        } else {

            validacionFecha = (validacionFecha.equals("La fecha es valida")) ? "" : validacionFecha;
            validacionHoras = (validacionHoras.equals("Las horas están correctas")) ? "" : validacionHoras;
            valicacionMotivoSolicitud = (valicacionMotivoSolicitud.equals("Motivo ingresado correctamente")) ? "" : valicacionMotivoSolicitud;
            verificacionConcurrencia = (verificacionConcurrencia.equals("El evento se puede registrar")) ? "" : verificacionConcurrencia;
            verificarEstadoActivo = (verificarEstadoActivo.equals("ok")) ? "" : verificarEstadoActivo;

            return "<html>Se observan los siguientes detalles, por favor verifique: <br><br> " + "<table class=\"egt\" border=\"1\">"
                    + validacionFecha
                    + validacionHoras
                    + valicacionMotivoSolicitud
                    + verificacionConcurrencia
                    + verificarEstadoActivo
                    + "</table>" + "</html>";
        }

    }

    public String verificarEstadoEspacio(String Estado) {

        if ("En funcionamiento".equals(Estado)) {
            return "ok";
        } else {
            return "<tr><td>El espacio que quiere solicitar no está en funcionamiento en este momento</td></tr>";
        }

    }

    public String ingresarSolicitudNueva(Usuario par, Solicitud sol) {
        if (solicitud.insertarSolicitud(par, sol)) {
            return "Ingreso completo";
        }

        return "<tr><td>Problema ingreso SQL</td></tr>";
    }

    public boolean verificarCruceEventos(Usuario par, Solicitud sol) {

        if (sol.getEspacioidEspacio() == null) {
            return false;
        }

        return solicitud.verificarConcurrenciaEventos(par, sol);
    }

    public String verificarMotivoSolicitud(String motivo, String motivoOtro) {
        Pattern p = Pattern.compile("^[\\s]+.+[\\s].+");
        Matcher m = p.matcher(motivoOtro);
        boolean b = m.matches();

        Pattern d = Pattern.compile("^.+[\\s]{2,}");
        Matcher f = d.matcher(motivoOtro);
        boolean g = f.matches();

        Pattern r = Pattern.compile("^.+[\\s]{2,}.+");
        Matcher t = r.matcher(motivoOtro);
        boolean w = t.matches();

        if ("Seleccion".equals(motivo)) {
            return "<tr><td>No se selecciono un motivo</td></tr>";
        }

        if ("Otro".equals(motivo)) {
            if (motivoOtro.length() <= 2) {
                return "<tr><td>Motivo muy corto</td></tr>";
            }

            if (motivoOtro.length() > 50) {
                return "<tr><td>Motivo muy largo</td></tr>";
            }

            if (b || g || w || "".equals(motivoOtro)) {
                return "<tr><td>Motivo mal redactado</td></tr>";
            }
        }

        return "Motivo ingresado correctamente";
    }

    public String fechaBD(Usuario par) {

        return solicitud.getfechaBD(par);
    }

    public String verificarFechaActual(Usuario par, String fechaTermina, String fechaEmpieza) {
        //fecha con formato aaaa-mm-dd

        String[] splitFechaTer = fechaTermina.split("-");
        String[] spliFechaEmp = fechaEmpieza.split("-");

        if (Integer.parseInt(splitFechaTer[1]) > 12 || Integer.parseInt(spliFechaEmp[1]) > 12 || Integer.parseInt(splitFechaTer[1]) < 0 || Integer.parseInt(spliFechaEmp[1]) < 0) {
            return "<tr><td>Fecha de mes sin sentido</td></tr>";
        }

        if (Integer.parseInt(splitFechaTer[2]) < 0 || Integer.parseInt(spliFechaEmp[2]) < 0 || Integer.parseInt(splitFechaTer[2]) > 31 || Integer.parseInt(spliFechaEmp[2]) > 31) {
            return "<tr><td>Fecha de dia sin sentido</td></tr>";
        }

        if (Integer.parseInt(splitFechaTer[0]) < Integer.parseInt(spliFechaEmp[0])) {
            return "<tr><td>Fecha terminacion con año antes de fecha inicio</td></tr>";
        } else if (Integer.parseInt(splitFechaTer[0]) == Integer.parseInt(spliFechaEmp[0])) {
            if (Integer.parseInt(splitFechaTer[1]) < Integer.parseInt(spliFechaEmp[1])) {
                return "<tr><td>Fecha terminacion con mes antes de fecha inicio</td></tr>";
            } else if (Integer.parseInt(splitFechaTer[1]) == Integer.parseInt(spliFechaEmp[1])) {
                if (Integer.parseInt(splitFechaTer[2]) < Integer.parseInt(spliFechaEmp[2])) {
                    return "<tr><td>Fecha terminacion con dia antes de fecha inicio</td></tr>";
                }
            }

        }

        if (solicitud.ComprobarfechaesMenorBD(par, fechaTermina) || solicitud.ComprobarfechaesMenorBD(par, fechaEmpieza)) {
            return "<tr><td>Alguna de las fechas ingresadas ya pasó</td></tr>";
        }

        return "La fecha es valida";
    }

    public String verificarHorasMinutosIngresadas(int horaInicio, int MinutosInicio, int horaFinal, int MinutosFinal) {

        if (horaInicio > 23 || horaFinal > 23 || horaInicio < 6 || horaFinal < 0) {
            return "<tr><td>La hora de inicio o de final no están en el horario adecuado</td></tr>";
        }

        if (MinutosFinal < 0 || MinutosInicio > 59 || MinutosInicio > 59 || MinutosInicio < 0) {
            return "<tr><td>Los minutos de inicio o final no tienen sentido</td></tr>";
        }

        if ((horaFinal - horaInicio) == 2 && (horaInicio == 6
                || horaInicio == 8
                || horaInicio == 10
                || horaInicio == 12
                || horaInicio == 13
                || horaInicio == 15
                || horaInicio == 17
                || horaInicio == 19
                || horaInicio == 21
                || horaInicio == 23)) {
            return "<tr><td>El horario de 2 horas seleccionado no es válido</td></tr>";
        }

        return "Las horas están correctas";
    }

}
