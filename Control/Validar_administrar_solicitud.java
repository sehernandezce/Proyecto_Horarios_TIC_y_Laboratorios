package Control;

import DAO.SolicitudDAO;
import Entidad.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public int cambiarEstado(Usuario par, String tipo_e, String id_solicitud, String Observacion) {

        int tipoE = convertirTipo_e(tipo_e);
        if (tipoE == 1) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else if (tipoE == 2) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else if (tipoE == 3) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else if (tipoE == 4) {
            return solicitud.cambiarEstado(par, tipoE, id_solicitud, Observacion);
        } else {
            return -1;
        }

    }

    public String[] obtenerListaMotivos(Usuario par) {
        return solicitud.obtenerMotivo(par);
    }

    public boolean verificarDatosSolicitudNueva() {
        boolean validacion = false;

        return validacion;
    }

}
