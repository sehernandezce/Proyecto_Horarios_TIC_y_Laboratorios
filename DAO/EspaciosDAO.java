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

    public String[][] leer(Usuario par, int tipEspacio) { // buscar todos los lugares conrespecto a un tipo de espacio
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
           
            resultSet = statement.executeQuery("CALL InfoporTipodeEspacio(" +tipEspacio+")");
            if(resultSet.next()){
                return ObtenerData(resultSet);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                //return null;
            } catch (SQLException ex) {

            }
        }

    }
    
    
    public String[][] leerHoras_espacios(Usuario par, int id_espacio, String fecha) { // buscar todos los lugares conrespecto a un tipo de espacio
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
           
            resultSet = statement.executeQuery("CALL Espacios_horas(" +id_espacio+","+fecha+")");
            if(resultSet.next()){
                return ObtenerData_Horas(resultSet);
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                //return null;
            } catch (SQLException ex) {

            }
        }

    }
    
    private String[][] ObtenerData(ResultSet resultSet) throws SQLException{
       
       int fila=0;       
       resultSet.afterLast();
       resultSet.previous();
      
       int tamanio=resultSet.getRow();
       resultSet.absolute(0);
     
       String[][] tabla=new String[tamanio][6];
       while(resultSet.next()){
        
           for(int i=2;i<7;i++){
               tabla[fila][i-2]=resultSet.getString(i);
              
           }
           tabla[fila][5]=resultSet.getString(1);
           fila++;
         }
       
       return tabla;
       }
    private String[][] ObtenerData_Horas(ResultSet resultSet) throws SQLException{
       
       int fila=0;       
       resultSet.afterLast();
       resultSet.previous();
      
       int tamanio=resultSet.getRow();
       resultSet.absolute(0);
     
       String[][] tabla=new String[tamanio][1];
       while(resultSet.next()){
            tabla[fila][1]=resultSet.getString(1)+"/"+resultSet.getString(2);
            fila++;
         }
       
       return tabla;
       }
            

     public Espacio leerunEspacio(Usuario par, int idEspacio) { // buscar todos los lugares conrespecto a un tipo de espacio
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
           
            resultSet = statement.executeQuery("CALL InforporEspacio(" +idEspacio+")");
            if(resultSet.next()){
                Espacio espacio= new Espacio();
                espacio.setId_espacio(Integer.valueOf(resultSet.getString(1)));
                espacio.setNombre_espacio(resultSet.getString(2));
                espacio.setNum_Espacio(resultSet.getString(3));
                espacio.setNombre_edificio(resultSet.getString(4));
                espacio.setNombre_encargado(resultSet.getString(5));
                if(resultSet.getString(6).equals("Activo")){
                    espacio.setEstado(true);
                }else{
                   espacio.setEstado(false);
                }                   
                espacio.setCapacidad(Integer.valueOf(resultSet.getString(7)));
                espacio.setNombre_tipoespacio(resultSet.getString(8));
                return espacio;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SQL" + ex);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                //return null;
            } catch (SQLException ex) {

            }
        }

    }
     
   
     
     
//    public boolean actualizar(Usuario par, Espacio espacio) {
//        Connection connection = null;
//        Statement statement = null;
//        int resultSet;
//        try {
//            resultSet = -1;
//            seleccionarUser(par.getTipoUsuario());
//            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
//            statement = connection.createStatement();            
//            
//            resultSet = statement.executeUpdate("UPDATE ESPACIOS "
//                    + "SET id_edificio = '" + espacio.getId_edificio() + "' , "
//                    + "id_tipoEspacio = '" + espacio.getTipoEspacio() + "' , "
//                    + "id_persona = '" + espacio.getId_encargado() + "' , "
//                    + "nombre_Espacio = '" + espacio.getNombreEspacio()+ "' , "
//                    + "num_espacio = '" + espacio.getNumEspacio()+ "' , "
//                    + "activo = " + espacio.getActivo()+ " , " 
//                    + "capacidad = '" + espacio.getCapacidad()
//                    + "' WHERE id_espacio='" + espacio.getId_Espacios()+ "';");
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
