package DAO;

import Entidad.Inventario;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class InventariosDAO {

    Connection connection = null;

    public InventariosDAO(Connection connection) {
        this.connection = connection;
    }

    public String[][] leer(Usuario par, int idEspacio) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select ID_INVENTARIO, NOMBREATRIBUTO, DESCRIPCION from INVENTARIOS where VIVO_INV=1 AND ID_ESPACIO=(" + idEspacio + ")");
            if (resultSet.next()) {
                return ObtenerData(resultSet);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();
                //return null;
            } catch (SQLException ex) {

            }
        }

    }

    private String[][] ObtenerData(ResultSet resultSet) throws SQLException {

        int fila = 0;
        resultSet.afterLast();
        resultSet.previous();
        int tamanio = resultSet.getRow();
        resultSet.absolute(0);

        String[][] tabla = new String[tamanio][3];
        while (resultSet.next()) {
            for (int i = 1; i < 4; i++) {
                tabla[fila][i - 1] = resultSet.getString(i);
            }
            fila++;
        }

        return tabla;
    }

    public boolean actualizar(Usuario par, ArrayList<Inventario> inventarioList, String id_espacio) {
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            statement = connection.createStatement();

            for (int i = 0; i < inventarioList.size(); i++) {

                resultSet = statement.executeUpdate("CALL Actualizar_Agregar_Inv ( "
                        + id_espacio + ",'"
                        + par.getNombreusuarioInstitucional() + "',"
                        + inventarioList.get(i).getId_inventario() + ",'"
                        + inventarioList.get(i).getNombreAtributo() + "','"
                        + inventarioList.get(i).getDescripcion() + "');");
            }
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();

            } catch (SQLException ex) {

            }
        }
    }

    public boolean eliminar(Usuario object, ArrayList<String> idinventarioList) {
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            statement = connection.createStatement();

            for (int i = 0; i < idinventarioList.size(); i++) {
                resultSet = statement.executeUpdate("UPDATE INVENTARIOS SET VIVO_INV=FALSE"
                        + "WHERE ID_INVENTARIO=" + idinventarioList.get(i) + ";");

            }
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();

            } catch (SQLException ex) {

            }
        }
    }
}
