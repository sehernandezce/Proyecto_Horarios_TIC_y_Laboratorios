package DAO;


import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventariosDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/loginapp"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER = "admin";
    static final String DB_PASSWD = "Ingenieriadesoftware1";

    public boolean crear(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        Usuario usuario = new Usuario();
        
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO usuarios( `NOMBRE`, `PASSWORD`, `TIENECODIGO`) VALUES (\""
                    + object.getNombre() + "\",\"" + object.getPassword()+"\"," +object.isTienecodigo() +")");
            
            return resultSet > 0;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }

    public boolean leer(Usuario par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM usuarios "
                    + "WHERE NOMBRE = '" + par.getNombre()
                    + "' AND PASSWORD='" + par.getPassword() + "'");
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return resultSet.next();
            } catch (SQLException ex) {

            }
        }

    }

    public boolean tieneCod(Usuario par) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM usuarios "
                    + "WHERE NOMBRE = '" + par.getNombre()
                    + "' AND PASSWORD='" + par.getPassword() + "'");
            if(resultSet.next()){
                return resultSet.getBoolean("TIENECODIGO");
            }
//            }else{
//                return false;
//            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                return resultSet.next();
            } catch (SQLException ex) {

            }
        }
        return false;
    }
    
    public boolean actualizar(Usuario oldUser, Usuario newUser) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            System.out.println("UPDATE usuarios "
                    + "SET NOMBRE = '" + newUser.getNombre() + "' , "
                    + "PASSWORD = '" + newUser.getPassword()
                    + "' WHERE NOMBRE='" + oldUser.getNombre()
                    + "' AND PASSWORD='" + oldUser.getPassword() + "';");
            
            resultSet = statement.executeUpdate("UPDATE usuarios "
                    + "SET NOMBRE = '" + newUser.getNombre() + "' , "
                    + "PASSWORD = '" + newUser.getPassword()
                    + "' WHERE NOMBRE='" + oldUser.getNombre()
                    + "' AND PASSWORD='" + oldUser.getPassword() + "';");
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

    public boolean eliminar(Usuario object) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("DELETE FROM usuarios "
                    + "WHERE NOMBRE='" + object.getNombre()
                    + "' AND PASSWORD='" + object.getPassword() + "';");
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
}
