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
        
        if(tipUser==1 || tipUser==4){
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
      public String[][] leer(Usuario par, int idEspacio) { // buscar todos los lugares conrespecto a un tipo de espacio
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
          
            resultSet = statement.executeQuery("select ID_INVENTARIO, NOMBREATRIBUTO, DESCRIPCION from INVENTARIOS where VIVO_INV=1 AND ID_ESPACIO=(" +idEspacio+")");
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
    
    private String[][] ObtenerData(ResultSet resultSet) throws SQLException{
       
       int fila=0;       
       resultSet.afterLast();
       resultSet.previous();
       int tamanio=resultSet.getRow();
       resultSet.absolute(0);
     
       String[][] tabla=new String[tamanio][3];
       while(resultSet.next()){
           for(int i=1;i<4;i++){
               tabla[fila][i-1]=resultSet.getString(i);
           }           
           fila++;
         }
       
       return tabla;
       }
            
        
    public boolean actualizar(Usuario par, ArrayList<Inventario>  inventarioList, String id_espacio) {//Modifica el invetario que ya existe mas no agrega nuevos
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet = -1;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();            
            
          
            
            for(int i=0; i<inventarioList.size(); i++){
                 
                resultSet = statement.executeUpdate("CALL Actualizar_Agregar_Inv ( "
                    +id_espacio+",'"
                    + par.getNombreusuarioInstitucional()+"',"
                    +inventarioList.get(i).getId_inventario()+",'"
                    +inventarioList.get(i).getNombreAtributo()+"','"
                    +inventarioList.get(i).getDescripcion() +"');");
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

    public boolean eliminar(Usuario object, ArrayList<String> idinventarioList) {
        Connection connection = null;
        Statement statement = null;
        int resultSet;
        try {
            resultSet=-1;
            seleccionarUser(object.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            
             for(int i=0; i<idinventarioList.size(); i++){
            resultSet = statement.executeUpdate("UPDATE INVENTARIOS SET VIVO_INV=FALSE"
                    + "WHERE ID_INVENTARIO="+idinventarioList.get(i)+ ";");
            
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
}
