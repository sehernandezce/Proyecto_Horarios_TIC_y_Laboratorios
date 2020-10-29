package DAO;


import Entidad.Inventario;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InventariosDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    private static  String DB_USER;
    private static  String DB_PASSWD;

    private void seleccionarUser(int tipUser){
        
        if(tipUser==1){
            this.DB_USER="UserStandard";
            this.DB_PASSWD="Us58*uQL";
        }else if(tipUser==2){
            this.DB_USER="UserCoordinator";
            this.DB_PASSWD="uC102*lPg";
        }
    }
    
//    public boolean crear(Usuario object) {// falta hacerla
//        Connection connection = null;
//        Statement statement = null;
//        int resultSet;
//        Usuario usuario = new Usuario();
//        
//        try {
//            resultSet = -1;
//            seleccionarUser(object.getTipoUsuario());
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
//            statement = connection.createStatement();
//            resultSet = statement.executeUpdate("INSERT INTO usuarios( `NOMBRE`, `PASSWORD`, `TIENECODIGO`) VALUES (\""
//                    + object.getNombre() + "\",\"" + object.getPassword()+"\"," +object.isTienecodigo() +")");
//            
//            return resultSet > 0;
//        } catch (SQLException ex) {
//            System.out.println("Error en SQL" + ex);
//            return false;
//        } finally {
//            try {
//                statement.close();
//                connection.close();
//            } catch (SQLException ex) {
//                System.out.println("Error en SQL" + ex);
//            }
//        }
//
//    }

    public ResultSet leer(Usuario par, int idEspacio) {// Busca el inventario de un espacio con su id.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM INVENTARIOS "
                    + "WHERE ID_ESPACIO = '" + idEspacio + "'");
            if(resultSet.next()){
                return resultSet;
            }else{
                return resultSet;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return resultSet;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return resultSet;
            } catch (SQLException ex) {

            }
        }

    }

        
    public boolean actualizar(Usuario par, ArrayList<Inventario>  inventarioList) {//Modifica el invetario que ya existe mas no agrega nuevos
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();            
            
            for(int i=0; i<inventarioList.size(); i++){
                resultSet = statement.executeUpdate("UPDATE INVENTARIOS "
                    + "SET ID_ESPACIO = '" + inventarioList.get(i).getId_Espacio() + "' , "
                    + "NOMBREATRIBUTO = '" + inventarioList.get(i).getNombreAtributo()+ "' , "
                    + "DESCRIPCION = '" + inventarioList.get(i).getDescripcion()
                    + "' WHERE id_inventario='" + inventarioList.get(i).getId_inventario()+ "';");
            }     
            
           return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
                connection.close();

            } catch (SQLException ex) {

            }
        }
    }

//    public boolean eliminar(Usuario object) {falta hacerlo
//        Connection connection = null;
//        Statement statement = null;
//        int resultSet;
//        try {
//            resultSet=-1;
//            seleccionarUser(object.getTipoUsuario());
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
//            statement = connection.createStatement();
//            resultSet = statement.executeUpdate("DELETE FROM usuarios "
//                    + "WHERE NOMBRE='" + object.getNombre()
//                    + "' AND PASSWORD='" + object.getPassword() + "';");
//            return resultSet > 0;
//        } catch (SQLException ex) {
//            System.out.println("Error en SQL" + ex);
//            return false;
//        } finally {
//            try {
//                statement.close();
//                connection.close();
//
//            } catch (SQLException ex) {
//
//            }
//        }
//    }
}
