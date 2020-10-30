package DAO;


import Control.ContraseniaHasheada;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
    
   
    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios?characterEncoding=utf8"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";
    static final String DB_USER = "SeeTableUser";
    static final String DB_PASSWD = "ISsRD1*y"; 
    private ContraseniaHasheada contraseniahasheada = new ContraseniaHasheada();
    
    public boolean crear(Usuario object) throws Exception { // Ingresar un usuario en la base de datos
        Connection connection = null;
        Statement statement = null;
        int resultSet;      
        
        try {
            resultSet = -1;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeUpdate("INSERT INTO USUARIOS( `ID_TIPOUSUARIO`, `USUARIOINSTITUCIONAL`, `CONTRASENIA`) VALUES ('"
                    + object.getTipoUsuario() + "','" + object.getNombreusuarioInstitucional()+"','" + contraseniahasheada.getSaltedHash(object.getContrasenia()) + "'" + ")" );
            
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

    public int leer(Usuario par) throws Exception { // Buscar un usuario en la base de datos. 0=Usuario no existe
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOINSTITUCIONAL = '" + par.getNombreusuarioInstitucional() + "'" );
 //                   + "' AND CONTRASENIA='" + par.getContrasenia() + "'");
            
            if(resultSet.next()){
                if(contraseniahasheada.check(par.getContrasenia(), resultSet.getString(4))){
                    int tipUser=Integer.valueOf(resultSet.getString(2));
                    return tipUser;
                }else{
                    return 0;  
                }             
            }else{
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return -3;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                    if(resultSet.next()){
                        return Integer.valueOf(resultSet.getString(2));
                    }else{
                        return 0;
                    }                
            } catch (SQLException ex) {

            }
        }

    }
    
    
    public boolean VerificarCode(String cod) throws Exception { // Verifica el codigo
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
         
        try {
            resultSet = null;
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();      
            resultSet = statement.executeQuery("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOINSTITUCIONAL = 'UserCode" 
                    + "', ID_TIPOUSUARIO = '3' ");
           //         + "AND CONTRASENIA='" + cod + "'");
            
            if(resultSet.next()){                    
                if(contraseniahasheada.check(cod, resultSet.getString(4))){
                   
                    return true;
                }else{
                    return false;  
                }    
                return false;
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
}
