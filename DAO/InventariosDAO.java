package DAO;

import Entidad.Inventario;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InventariosDAO {

    private Connection connection = null;
    private ConexionDAO conexionDao = new ConexionDAO();

    public InventariosDAO(Connection connection) {
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

    public String[][] leer(Usuario par, int idEspacio) {
        reconection(par);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = this.connection.createStatement();

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
        reconection(par);
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            statement = this.connection.createStatement();

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
            System.out.println("Error en SQL: -->" + ex);
            return false;
        } finally {
            try {
                statement.close();

            } catch (SQLException ex) {

            }
        }
    }

    public boolean eliminar(Usuario object, ArrayList<String> idinventarioList) {
        reconection(object);
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            statement = this.connection.createStatement();

            for (int i = 0; i < idinventarioList.size(); i++) {
                resultSet = statement.executeUpdate("UPDATE INVENTARIOS SET VIVO_INV=FALSE WHERE ID_INVENTARIO=" + idinventarioList.get(i) + ";");

            }
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL: --<" + ex);
            return false;
        } finally {
            try {
                statement.close();

            } catch (SQLException ex) {

            }
        }
    }
}
