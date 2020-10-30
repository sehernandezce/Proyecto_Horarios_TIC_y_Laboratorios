 
package Control;

import DAO.UsuarioDAO;
import DAO.EspaciosDAO;
import Entidad.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidarEspacios {
    
    
    EspaciosDAO espacioDao= new EspaciosDAO();
    public String[][] llenarMatriz(int tipoEspacio,Usuario par) throws SQLException{
       
       int fila=0;
       ResultSet resultSet= espacioDao.leer(par, tipoEspacio);
       resultSet.afterLast();
       int tamanio=resultSet.getRow();
       resultSet.absolute(1);
       String[][] tabla=new String[tamanio][6];
       while(resultSet.next()){
           for(int i=2;i<7;i++){
               tabla[fila][i-2]=resultSet.getString(i);
               
           }
           tabla[fila][5]=resultSet.getString(1);
         }
       
       return tabla;
       }
        
    
    

    public  ValidarEspacios(){
        
    }
    
    
    

}
