package DAO;

import Control.ContraseniaHasheada;
import Control.EncriptadorAES;
import Control.EnviarCorreo;
import Control.ManipularConecciones;
import Entidad.Correo;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios";
    static final String DB_USER = "SeeTableUser"; 
    static final String DB_PASSWD = "ISsRD1*y"; 
    
    Connection connection = null;
    private ContraseniaHasheada contraseniahasheada = new ContraseniaHasheada();
    private EncriptadorAES encriptadorAES = new EncriptadorAES();
    private ConexionDAO conexionDao = new ConexionDAO();

    public UsuarioDAO(Connection connection) {
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            conexionDao.setConnection(this.connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public boolean crear(Usuario object) throws Exception { 
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet2 = null;
        int resultSet;

        try {
            resultSet = -1;
            statement = connection.createStatement();
            resultSet2 = statement.executeQuery("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOINSTITUCIONAL = '" + object.getNombreusuarioInstitucional() + "'");
            if (resultSet2.next()) {
                return false;
            } else {
                resultSet = statement.executeUpdate("INSERT INTO USUARIOS( `ID_TIPOUSUARIO`, `USUARIOINSTITUCIONAL`, `CONTRASENIA`) VALUES ('"
                        + object.getTipoUsuario() + "','" + object.getNombreusuarioInstitucional() + "','" + contraseniahasheada.getSaltedHash(object.getContrasenia()) + "'" + ")");
                return resultSet > 0;
            }

        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }

    public int leer(Usuario par) throws Exception { 
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOINSTITUCIONAL = '" + par.getNombreusuarioInstitucional() + "'" );
            
            if(resultSet.next()){
                if(contraseniahasheada.check(par.getContrasenia(), resultSet.getString(3))){
                    int tipUser=Integer.valueOf(resultSet.getString(1));
                    return tipUser;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return -3;
        } finally {
            try {
                resultSet.close();
                statement.close();
                if (resultSet.next()) {
                    return Integer.valueOf(resultSet.getString(1));
                } else {
                    return 0;
                }
            } catch (SQLException ex) {

            }
        }

    }
    
    
    public boolean VerificarCode(String cod) throws Exception { 
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOINSTITUCIONAL = 'UserCode"
                    + "'AND ID_TIPOUSUARIO = '3' ");
           
            
            if(resultSet.next()){                    
                if(contraseniahasheada.check(cod, resultSet.getString(3))){
                   
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                resultSet.close();
                statement.close();
                return resultSet.next();

            } catch (SQLException ex) {

            }
        }

    }
    
      public String existir(String user) throws Exception {
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USUARIOS "
                    + "WHERE USUARIOINSTITUCIONAL = '" + user + "'");
            if (resultSet.next()) {
                return "true";
            } else {
                return "false";
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return "false";
        } finally {
            try {
                resultSet.close();
                statement.close();
                if (resultSet.next()) {
                    return "true";
                } else {
                    return "false";
                }
            } catch (SQLException ex) {

            }
        }

    }

    public int AgreCod(String u, Correo correo, String cod) throws Exception { // Ingresar un usuario en la base de datos
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet2 = null;
        int resultSet;

        try {
            resultSet = -1;
            statement = connection.createStatement();
            resultSet2 = statement.executeQuery("SELECT COUNT(*) FROM CODIGOS_SEGURIDAD WHERE USUARIOINSTITUCIONAL='"
                    + u
                    + "' AND DATE_ADD(Fecha_de_creacion_codigo,INTERVAL 24 HOUR) >= NOW( )"
                    + "AND utilizado_codigo=0;");

            if (resultSet2.next()) {
                if (resultSet2.getString(1).equals("0")) {
                    resultSet = statement.executeUpdate("CALL CrearCod('" + u + "','"
                            + contraseniahasheada.getSaltedHash(cod) + "')");
                    if (resultSet > 0) {
                        EnviarCorreo enviarCorreo = new EnviarCorreo();
                        enviarCorreo.setManipularConexion(new ManipularConecciones());
                        if (enviarCorreo.enviarC(correo)) {
                            return 1;
                        } else {
                            VerificarCode(cod, u);
                            return -3;
                        }
                    } else {
                        return -4;
                    }
                } else {
                    return -2;
                }
            }

            return -1;
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return -1;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }
        
    public boolean VerificarCode(String cod, String U) throws Exception { 
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            int resultSet2 = -1;
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select now();");
            if (existir(U).equals("false")) {
                System.out.println("entreo no existe");
                return false;
            } else {
                System.out.println(existir(U));
                resultSet = statement.executeQuery("CALL verifCode('" + U + "')");
                boolean verifcod = false;
                resultSet.afterLast();
                if (resultSet.previous()) {
                    if (contraseniahasheada.check(cod, resultSet.getString(2))) {
                        //;
                        resultSet2 = statement.executeUpdate("update CODIGOS_SEGURIDAD set utilizado_codigo=1 where idCODIGOS_SEGURIDAD=" + resultSet.getString(1) + ";");
                        if (resultSet2 > 0) {
                            verifcod = true;
                        }
                    }
                }
                return verifcod;

            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                resultSet.close();
                statement.close();

            } catch (SQLException ex) {

            }
        }

    }
    
      public boolean actualizarPASS(Usuario object) throws Exception { 
        this.conexionDao.Reconnection(-10);
        Statement statement = null;

        try {
            int resultSet2 = -1;
            statement = connection.createStatement();
            resultSet2 = statement.executeUpdate("UPDATE USUARIOS "
                    + "SET contrasenia='" + contraseniahasheada.getSaltedHash(object.getContrasenia()) + "' WHERE USUARIOINSTITUCIONAL = '" + object.getNombreusuarioInstitucional() + "';");
            if (resultSet2 > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }
      
    
      public boolean actualizarCorreoNot(Usuario object) throws Exception { 
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            int resultSet2 = -1;
            statement = connection.createStatement();

            resultSet = statement.executeQuery("Select count(*) from USUARIOS "
                    + " WHERE ID_TIPOUSUARIO = 5 ");

            resultSet.next();
            if (resultSet.getString(1).equals("1")) {
                resultSet2 = statement.executeUpdate("UPDATE USUARIOS "
                        + "SET contrasenia='" + encriptadorAES.encriptar(object.getContrasenia(), "koUyrt90*65!")
                        + "', USUARIOINSTITUCIONAL='" + encriptadorAES.encriptar(object.getNombreusuarioInstitucional(), "koUyrt90*5!")
                        + "' WHERE ID_TIPOUSUARIO =5;");

                if (resultSet2 > 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (resultSet.getString(1).equals("0")) {

                resultSet2 = statement.executeUpdate("INSERT INTO USUARIOS( `ID_TIPOUSUARIO`, `USUARIOINSTITUCIONAL`, `CONTRASENIA`) VALUES ('"
                        + "5" + "','" + encriptadorAES.encriptar(object.getNombreusuarioInstitucional(), "koUyrt90*5!") + "','" + encriptadorAES.encriptar(object.getContrasenia(), "koUyrt90*65!") + "');");
                if (resultSet2 > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Error en SQL" + ex);
            }
        }

    }
     
    public Usuario leerCorreoNotificar() throws Exception { 
        this.conexionDao.Reconnection(-10);
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM USUARIOS "
                    + "WHERE ID_TIPOUSUARIO = 5; ");

            if (resultSet.next()) {
                Usuario u = new Usuario();
                u.setNombreusuarioInstitucional(encriptadorAES.desencriptar(resultSet.getString(2), "koUyrt90*5!"));
                u.setContrasenia(encriptadorAES.desencriptar(resultSet.getString(3), "koUyrt90*65!"));
                return u;
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
            } catch (SQLException ex) {

            }
        }

    }
}
