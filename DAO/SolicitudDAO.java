package DAO;

import Entidad.Solicitud;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SolicitudDAO {

    private Connection connection = null;
    private ConexionDAO conexionDao = new ConexionDAO();

    public SolicitudDAO(Connection connection) {
        this.connection = connection;
        this.conexionDao.setConnection(this.connection);
    }

    public void reconection(Usuario par) {

        try {

            if (connection.isClosed()) {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "¿Se ha perdido la conexión con el servidor, intentar reconectar con el servidor?", "Exit", dialog);
                if (result == 0) {
                    this.connection = this.conexionDao.Reconnection(par.getTipoUsuario());
                    reconection(par);
                } else {
                    JOptionPane.showMessageDialog(null, "El programa se cerrará por falta de conexion con el servidor", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EspaciosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String[][] leerSolicitudesEspacio(Usuario par, int idEspacio) {

        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            resultSet = null;
            resultSet = statement.executeQuery("");
            statement = this.connection.createStatement();
            if (resultSet.next()) {

                return ObtenerData_solicitudes(resultSet);
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (Exception ex) {

            }
        }

    }

    public String[][] leerSolicitudes(Usuario par, int tipo_e) {
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("CALL Ver_solicitudes_estado('" + par.getNombreusuarioInstitucional() + "','" + tipo_e + "')");
            if (resultSet.next()) {

                return ObtenerData_solicitudes(resultSet);
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (Exception ex) {

            }
        }

    }

    private String[][] ObtenerData_solicitudes(ResultSet resultSet) throws SQLException {

        int fila = 0;
        resultSet.afterLast();
        resultSet.previous();

        int tamanio = resultSet.getRow();
        resultSet.absolute(0);

        String[][] tabla = new String[tamanio][10];
        while (resultSet.next()) {

            for (int i = 1; i < 10; i++) {
                if (i != 3) {
                    tabla[fila][i - 1] = resultSet.getString(i);
                } else {
                    tabla[fila][i - 1] = convertirTipo_e(Integer.parseInt(resultSet.getString(i)));
                }
            }
            tabla[fila][9] = "Ver más";
            fila++;
        }

        return tabla;
    }

    private String convertirTipo_e(int estado) {
        if (estado == 1) {
            return "Aceptada";
        } else if (estado == 2) {
            return "Espera";
        } else if (estado == 3) {
            return "Rechazada";
        } else if (estado == 4) {
            return "Cancelada";
        } else {
            return null;
        }
    }

    public String getfechaBD(Usuario par) {
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("select curdate()");

            resultSet.next();

            return (resultSet.getString(1));

        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (Exception ex) {

            }
        }

    }

    public boolean ComprobarfechaesMenorBD(Usuario par, String fechaIngresada) {
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();

            resultSet = statement.executeQuery("select curdate() > '" + fechaIngresada + "'");

            resultSet.next();

            return (resultSet.getInt(1) == 1);

        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return true;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (Exception ex) {

            }
        }
    }

    public int cambiarEstado(Usuario par, int tipo_e, String id_solicitud, String obs) { // buscar las solicitudes dependiendo el estado y tipo de usuario
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("Select cambiar_estado('" + par.getNombreusuarioInstitucional() + "'," + id_solicitud + "," + tipo_e + ",'" + obs + "')");
            if (resultSet.next()) {
                return Integer.valueOf(resultSet.getString(1));
            } else {
                return -2;
            }
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return -2;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (Exception ex) {

            }
        }

    }

    public boolean insertarSolicitud(Usuario par, Solicitud sol) {
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet size = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();

            int[] dias = sol.getEvento().getDiasRepite();
            String diasString = "";
            for (int dia : dias) {
                diasString = diasString + dia;
            }

            resultSet = statement.executeQuery("call Horarios_Tics_y_Laboratorios.Ingresar_Solicitud("
                    + sol.getEvento().getTipoRepetición()
                    + ", '" + sol.getEvento().getFechaEvento()
                    + "', '" + sol.getEvento().getHoraInicio()
                    + "', '" + sol.getEvento().getHoraFinalEvento()
                    + "', '" + sol.getEvento().getFechaTerminaEvento()
                    + "', '" + sol.getEvento().getMotivoEvento()
                    + "', '" + sol.getEvento().getIdMotivoEvento()
                    + "', '" + par.getNombreusuarioInstitucional()
                    + "', '" + sol.getEspacioidEspacio()
                    + "', '" + diasString + "');");

            return true;
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {

                resultSet.close();
                size.close();
                statement.close();

            } catch (Exception ex) {

            }
        }

    }

    public boolean verificarConcurrenciaEventos(Usuario par, Solicitud sol) {
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet size = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();

            int[] dias = sol.getEvento().getDiasRepite();
            String diasString = "";
            for (int dia : dias) {
                diasString = diasString + dia;
            }

            resultSet = statement.executeQuery("select Horarios_Tics_y_Laboratorios.compararEventos("
                    + sol.getEspacioidEspacio()
                    + ", '" + sol.getEvento().getHoraInicio()
                    + "', '" + sol.getEvento().getHoraFinalEvento()
                    + "', " + sol.getEvento().getTipoRepetición()
                    + ", '" + sol.getEvento().getFechaEvento() + "', '" + sol.getEvento().getFechaTerminaEvento() + "', '" + diasString + "');");

            resultSet.next();

            return (resultSet.getInt(1) == 1);
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {

                resultSet.close();
                size.close();
                statement.close();

            } catch (Exception ex) {

            }
        }
    }

    public String[] obtenerMotivo(Usuario par) {
        
        reconection(par);
        String[] retorno;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet size = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM MOTIVOS_EVENTOS");

            resultSet.afterLast();
            resultSet.previous();

            int tamanio = resultSet.getRow();
            resultSet.absolute(0);

            int i = 0;

            retorno = new String[tamanio];

            while (resultSet.next()) {
                retorno[i] = resultSet.getNString(2);
                i++;
            }

            return retorno;
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {

                resultSet.close();
                size.close();
                statement.close();

            } catch (Exception ex) {

            }
        }
    }

    public String[] leerunaSolicitud(Usuario par, int id_solicitud) { // buscar datos en especifico de una solicitud
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("CALL infoporSolicitud(" + id_solicitud + ")");
            String[] datos = new String[10];
            if (resultSet.next()) {
                for (int i = 1; i <= 10; i++) {
                    datos[i - 1] = resultSet.getString(i);
                }
            } else {
                return null;
            }
            return datos;
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (Exception ex) {

            }
        }

    }

    public String leerdias_soli(Usuario par, int id_solicitud) { // buscar las solicitudes dependiendo el estado y tipo de usuario
        
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery("SELECT dias_del_evento(" + id_solicitud + ")");
            if (resultSet.next()) {
                return ObtenerDias_solicitud(resultSet);
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (Exception ex) {

            }
        }

    }

    private String ObtenerDias_solicitud(ResultSet resultSet) throws SQLException {
        String dias = "";
        String[] dias_A = null;

        dias_A = resultSet.getString(1).split(",");

        for (int i = 0; i < dias_A.length; i++) {
            if (dias_A[i].equals("")) {
                continue;
            } else {
                if (dias.length() == 0) {
                    dias = convertir_Dia(Integer.parseInt(dias_A[i]));
                } else {
                    dias = dias + "-" + convertir_Dia(Integer.parseInt(dias_A[i]));
                }

            }
        }
        return dias;

    }

    public String convertir_Dia(int dia) {
        if (dia == 1) {
            return "Domingo";
        } else if (dia == 2) {
            return "Lunes";
        } else if (dia == 3) {
            return "Martes";
        } else if (dia == 4) {
            return "Miercoles";
        } else if (dia == 5) {
            return "Jueves";
        } else if (dia == 6) {
            return "Viernes";
        } else if (dia == 7) {
            return "Sabado";
        } else {
            return null;
        }
    }
}
