package DAO;


import Entidad.Espacio;
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EspaciosDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";

    private static String DB_USER;
    private static String DB_PASSWD;

    private void seleccionarUser(int tipUser){
        
        if(tipUser==1){
            this.DB_USER="UserStandard";
            this.DB_PASSWD="Us58*uQL";
        }else if(tipUser==2){
            this.DB_USER="UserCoordinator";
            this.DB_PASSWD="uC102*lPg";
        }
    }
    
//    public boolean crear(Usuario object) {
//        Connection connection = null;
//        Statement statement = null;
//        int resultSet;
//        Usuario usuario = new Usuario();
//        
//        try {
//            resultSet = -1;
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
//Select * From ESPACIOS Natural join ENCARGADOS;
    
    
    /*
    select distinct  esp.ID_ESPACIO,  esp.NOMBRE_ESPACIO,  esp.NUM_ESPACIO, edi.NOMBRE_EDIFICIOS, CONCAT(enc.NOMBRE_PERSONA, ' ' ,enc.APELLIDO_PERSONA) as nombre , esp.ACTIVO, esp.CAPACIDAD,  tesp.NOMBRE_TIPOESPACIO ,   enc.ID_PERSONA from ESPACIOS as espa, 
    ESPACIOS as esp, 
    TIPO_ESPACIOS as tesp, 
    ENCARGADOS as enc, 
    EDIFICIOS as edi
    where esp.id_edificio=edi.id_edificio
    and esp.ID_TIPOESPACIO=tesp.ID_TIPOESPACIO
    and esp.ID_PERSONA=enc.ID_PERSONA
    and esp.ID_TIPOESPACIO = ;
    */
    public ResultSet leer(Usuario par, int tipEspacio) { // buscar todos los lugares conrespecto a un tipo de espacio
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT *FROM ESPACIOS  "
                    + "WHERE id_tipoEspacio = '" + tipEspacio+ "' NATURAL JOIN ENCARGADOS");
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

       
    public boolean actualizar(Usuario par, Espacio espacio) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();            
            
            resultSet = statement.executeUpdate("UPDATE ESPACIOS "
                    + "SET id_edificio = '" + espacio.getId_edificio() + "' , "
                    + "id_tipoEspacio = '" + espacio.getTipoEspacio() + "' , "
                    + "id_persona = '" + espacio.getId_encargado() + "' , "
                    + "nombre_Espacio = '" + espacio.getNombreEspacio()+ "' , "
                    + "num_espacio = '" + espacio.getNumEspacio()+ "' , "
                    + "activo = " + espacio.getActivo()+ " , " 
                    + "capacidad = '" + espacio.getCapacidad()
                    + "' WHERE id_espacio='" + espacio.getId_Espacios()+ "';");
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

//    public boolean eliminar(Usuario object) {
//        Connection connection = null;
//        Statement statement = null;
//        int resultSet;
//        try {
//            resultSet=-1;
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
