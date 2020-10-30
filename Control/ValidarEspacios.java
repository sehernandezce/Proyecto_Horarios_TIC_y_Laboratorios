 
package Control;

import DAO.UsuarioDAO;
import DAO.EspaciosDAO;
import Entidad.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidarEspacios {
    
    
    private EspaciosDAO espacioDao= new EspaciosDAO();
    
    public  ValidarEspacios(){
        
    }
    
     public String[][] llenarMatriz(String tipoEspacio,Usuario par) throws SQLException{
       return espacioDao.leer(par, AsignartipEsp(tipoEspacio));
       }
    
    
    private int AsignartipEsp(String tipoEspacio){
        
        if(tipoEspacio.equals("Laboratorios")){
            return 1;
        }else if(tipoEspacio.equals("Sala de reuniones")){
            return 2;
        }else if(tipoEspacio.equals("Sala de computadores")){
             return 3;
        }else if(tipoEspacio.equals("Auditorios")){
           return 4;
        }else{
           return 0;
        }
    }
    

}
