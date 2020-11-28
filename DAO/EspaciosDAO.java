package DAO;

import Entidad.Espacio;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EspaciosDAO {

    Connection connection = null;

    public EspaciosDAO(Connection connection) {
        this.connection = connection;
    }

    public int crearEspacio(Usuario par, Espacio Espacio) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();
        
            resultSet = statement.executeQuery("INSERT INTO `Horarios_Tics_y_Laboratorios`.`ESPACIOS`(`ID_EDIFICIO`, `ID_TIPOESPACIO`, `ID_PERSONA`, `NOMBRE_ESPACIO`, `NUM_ESPACIO`, `ACTIVO`, `CAPACIDAD`) VALUES ('"
                    + Espacio.getNum_edificio() + ",'"
                    + Espacio.getNombre_tipoespacio() + "',"
                    + Espacio.getNombre_encargado() + ","
                    + Espacio.getNombre_espacio() + ",'"
                    + Espacio.getNum_Espacio() + "',"
                    + Espacio.getEstado() + ","
                    + Espacio.getCapacidad()
                    + ")");
            if (resultSet.next()) {
                return Integer.valueOf(resultSet.getString(1));
            } else {
                return -4;
            }
        } catch (Exception e) {
            System.out.println("Error en SQL" + e);
            return -4;
        } finally {
            try {
                resultSet.close();
                statement.close();
               
            } catch (Exception ex) {

            }
        }
    }
    
    public String[][] leer(Usuario par, int tipEspacio) { 
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery("CALL InfoporTipodeEspacio(" + tipEspacio + ")");
            if (resultSet.next()) {
                return ObtenerData(resultSet);
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
                //return null;
            } catch (Exception ex) {

            }
        }

    }

    public String[][] leerHoras_espacios(Usuario par, int id_espacio, String fecha, int day) { // buscar todos los lugares conrespecto a un tipo de espacio
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery("call Horarios_Tics_y_Laboratorios.Obtener_Horas_espacio('" + id_espacio + "','" + fecha + "','" + day + "')");
            System.out.println("call Horarios_Tics_y_Laboratorios.Obtener_Horas_espacio('" + id_espacio + "','" + fecha + "','" + day + "')");
            if (resultSet.next()) {

                return ObtenerData_Horas(resultSet);
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
                //return null;
            } catch (Exception ex) {

            }
        }

    }

    public int borrarEspacio(Usuario par, String idEspacio) {
        Statement statement = null;
        int resultSet = -1;
        ResultSet resultSet2 = null;
        try {
            statement = connection.createStatement();
            resultSet2 = statement.executeQuery("Select * from SOLICITUDES where ID_ESPACIO='" + idEspacio + " ' AND (ID_ESTADO =2);");
            if (!resultSet2.next()) {
                resultSet = statement.executeUpdate("update ESPACIOS set VIVO = false, ACTIVO = false where ID_ESPACIO = " + idEspacio + ";");
                if (resultSet > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -2;
            }
        } catch (Exception ex) {
            System.out.println("Error en SQL" + ex);
            return -1;
        } finally {
            try {
                resultSet2.close();
                statement.close();
            } catch (Exception ex) {

            }
        }
    }

    private String[][] ObtenerData(ResultSet resultSet) throws SQLException {

        int fila = 0;
        resultSet.afterLast();
        resultSet.previous();

        int tamanio = resultSet.getRow();
        resultSet.absolute(0);

        String[][] tabla = new String[tamanio][7];
        while (resultSet.next()) {

            for (int i = 1; i < 7; i++) {
                tabla[fila][i - 1] = resultSet.getString(i);

            }
            tabla[fila][6] = "Ver más";
            fila++;
        }

        return tabla;
    }

    private String[][] ObtenerData_Horas(ResultSet resultSet) throws SQLException {

        int fila = 0;
        resultSet.afterLast();
        resultSet.previous();

        int tamanio = resultSet.getRow();
        resultSet.absolute(0);

        String[][] tabla = new String[tamanio][1];
        while (resultSet.next()) {
            tabla[fila][0] = resultSet.getString(1) + "/" + resultSet.getString(2);
            fila++;
        }

        return tabla;
    }

    public Espacio leerunEspacio(Usuario par, int idEspacio) { 
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();

            resultSet = statement.executeQuery("CALL InforporEspacio(" + idEspacio + ")");
            if (resultSet.next()) {
                Espacio espacio = new Espacio();
                espacio.setId_espacio(Integer.valueOf(resultSet.getString(1)));
                espacio.setNombre_espacio(resultSet.getString(2));
                espacio.setNum_Espacio(resultSet.getString(3));
                espacio.setNombre_edificio(resultSet.getString(4));
                espacio.setNum_edificio(Integer.valueOf(resultSet.getString(5)));
                espacio.setNombre_encargado(resultSet.getString(6));
                espacio.setCorreo_encargado(resultSet.getString(7));
                if (resultSet.getString(8).equals("Activo")) {
                    espacio.setEstado(true);
                } else {
                    espacio.setEstado(false);
                }
                espacio.setCapacidad(Integer.valueOf(resultSet.getString(9)));

                espacio.setNombre_tipoespacio(resultSet.getString(10));
                return espacio;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error en SQL" + e);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();
                //return null;
            } catch (Exception ex) {

            }
        }

    }

    public int ActualizarinfoEspacio(Usuario par, Espacio Espacio) { 
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select actualizarEspacio('" + par.getNombreusuarioInstitucional() + "',"
                    + Espacio.getId_espacio() + ","
                    + Espacio.getNombre_tipoespacio() + ",'"
                    + Espacio.getNombre_espacio() + "',"
                    + Espacio.getNum_Espacio() + ","
                    + Espacio.getNum_edificio() + ",'"
                    + Espacio.getNombre_edificio() + "','"
                    + Espacio.getCorreo_encargado() + "','"
                    + Espacio.getNombre_encargado() + "',"
                    + Espacio.getEstado() + ","
                    + Espacio.getCapacidad()
                    + ")");
            if (resultSet.next()) {
                return Integer.valueOf(resultSet.getString(1));
            } else {
                return -4;
            }
        } catch (Exception e) {
            System.out.println("Error en SQL" + e);
            return -4;
        } finally {
            try {
                resultSet.close();
                statement.close();
             
            } catch (Exception ex) {

            }
        }

    }

    public int buscarEspacio(Usuario par, Espacio esp) throws SQLException {
        Statement statement = null;
        ResultSet res = null;

        String sql1 = "select count(ESPACIOS.NUM_ESPACIO)FROM ESPACIOS WHERE NUM_ESPACIO = '" + esp.getNum_Espacio() + "' || NOMBRE_ESPACIO='" + esp.getNombre_espacio() + "'";

        try {
            statement = connection.createStatement();
            res = statement.executeQuery(sql1);
            if (res.getInt(1) == 0) {
                return res.getInt(1);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        } finally {
            try {
                res.close();
                statement.close();
                //return null;
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }
        }
        return res.getInt(1);
    }

}
