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

    private SolicitudDAO solicitud = new SolicitudDAO();

    public Validar_administrar_solicitud() {
    }

    public String[][] llenarMatriz(Usuario par, String tipo_e) throws SQLException {
        return solicitud.leerSolicitudes(par, convertirTipo_e(tipo_e));
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
        int tipoEA=convertirTipo_e(tipeA);
        if(tipoE==tipoEA){
             return -5;
        }else if(tipoE==3 && tipoEA==1){
            return -5;
        }else if(tipoE==4 && tipoEA==3){
            return -5;
        }else if((tipoE==1 || tipoE==3) && tipoEA==4){
            return -5;
        }else if (tipoE == 1) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else if (tipoE == 3) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else if (tipoE == 4) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else {
            return -1;
        }

    }
    
    
    public boolean verificarEnvio(String contrasenia, String id, String tipE, String correoU, String obs)throws AddressException{
       
        Correo correo =new Correo();        
        correo.setAsunto("Respuesta a su solicitud con ID: "+id);
         correo.setMensaje("Estimado/a <b>Usuario</b>,<br> Queremos informale que su solicitud con id: "+id
        +"Ha cambiado al estado:<b> "+tipE+"</b>. A continuación se muestra la/s observacion/es indicadas por el coordinador:<br>"+obs+"<br>Muchas gracias por su atención.<br>Por favor, no reponder ha este correo.");
        correo.setCorreoReceptor(correoU+"@unal.edu.co");
        correo.setPasswordRemitente(contrasenia);
        EnviarCorreo enviarCorreo=new EnviarCorreo();        
        return enviarCorreo.enviarC(correo);              
    }

    public String[] obtenerListaMotivos(Usuario par) {
        return solicitud.obtenerMotivo(par);
    }

    public boolean verificarDatosSolicitudNueva(Usuario par, Solicitud sol, String motivo, String motivoOtro, String fechaTermina, String fechaEmpieza, int horaInicio, int MinutosInicio, int horaFinal, int MinutosFinal) {
        boolean validacion = false;

        //Horas inicio y final con sentido+
        //fecha termina superior a fecha actual y fecha seleccionada
        //fecha seleccionada superior a fecha actual
        //motivo de solicitud distinto de "seleccionar"
        //si el motivo es otro que no sea muy largo o muy corto, ni vacio
        //verificar con funcionBD si el evento no se cruza con otro
        
        if(verificarCruceEventos( par,  sol) && "Motivo funcional".equals(verificarMotivoSolicitud(motivo, motivoOtro)) && 
                "Fecha ingresada con exito".equals(verificarFechaActual(par, fechaTermina, fechaEmpieza)) && 
                        "Las horas están correctas".equals(verificarHorasMinutosIngresadas(horaInicio, MinutosInicio, horaFinal, MinutosFinal))){
        
            return true;
        }
        
        
        
        
        return validacion;
    }

    private boolean verificarCruceEventos(Usuario par, Solicitud sol){
        return solicitud.verificarConcurrenciaEventos(par, sol) ;
    }
    
    private String verificarMotivoSolicitud(String motivo, String motivoOtro) {
        Pattern p = Pattern.compile("[a-zA-Z ]+");
        Matcher m = p.matcher(motivoOtro);
        boolean b = m.matches();

        if ("Seleccion".equals(motivo)) {
            return "No se selecciono un motivo";
        }

        if ("Otro".equals(motivo)) {
            if (motivoOtro.length() > 2) {
                return "Motivo muy corto";
            }

            if (motivo.length() > 50) {
                return "Motivo muy largo";
            }

            if (!b) {
                return "Escriba algo por favor";
            }
        }

        return "Motivo funcional";
    }

    public String fechaBD(Usuario par){
    
        return solicitud.getfechaBD(par);
    }
    
    private String verificarFechaActual(Usuario par, String fechaTermina, String fechaEmpieza) {
        //fecha con formato aaaa-mm-dd

        String[] splitFechaTer = fechaTermina.split("-");
        String[] spliFechaEmp = fechaEmpieza.split("-");

        if (Integer.parseInt(splitFechaTer[0]) < Integer.parseInt(spliFechaEmp[0])) {
            return "Fecha terminacion con anio antes de fecha inicio";
        }

        if (Integer.parseInt(splitFechaTer[1]) < Integer.parseInt(spliFechaEmp[1])) {
            return "Fecha terminacion con mes antes de fecha inicio";
        }

        if (Integer.parseInt(splitFechaTer[2]) < Integer.parseInt(spliFechaEmp[2])) {
            return "Fecha terminacion con dia antes de fecha inicio";
        }

        if (solicitud.ComprobarfechaesMenorBD(par, fechaTermina) || solicitud.ComprobarfechaesMenorBD(par, fechaEmpieza)) {
            return "Fecha ingresada ya pasada";
        }

        return "Fecha ingresada con exito";
    }

    private String verificarHorasMinutosIngresadas(int horaInicio, int MinutosInicio, int horaFinal, int MinutosFinal) {

        if (horaInicio >= horaFinal) {
            return "La hora de inicio es mayor a la hora final";
        }

        if (horaInicio > 25 || horaFinal > 25 || horaInicio < 0 || horaFinal < 0) {
            return "La hora de inicio o de final no tienen sentido";
        }

        if (MinutosFinal < 0 || MinutosInicio > 59 || MinutosInicio > 59 || MinutosInicio < 0) {
            return "Los minutos de inicio o final no tienen sentido";
        }

        return "Las horas están correctas";
    }

}
