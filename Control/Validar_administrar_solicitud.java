package Control;

import DAO.SolicitudDAO;
import Entidad.Correo;
import Entidad.Usuario;
import java.sql.SQLException;
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

    public boolean verificarDatosSolicitudNueva() {
        boolean validacion = false;

        return validacion;
    }

}
