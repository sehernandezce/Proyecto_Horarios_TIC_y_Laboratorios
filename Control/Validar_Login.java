 
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;


public class Validar_Login {
    private UsuarioDAO dao = new UsuarioDAO();
    
    public  Validar_Login(){
        
    }
    
    public String verificarLogin(Usuario usuario){
        if (!verificarLongitudNombre (usuario.getNombreusuarioInstitucional())){
            return("Longitud nombre incorrecta");
        }
         if (!verificarLongitudPassword (usuario.getContrasenia())){
            return("Longitud contraseña incorrecta");
        }
         
          if(dao.leer(usuario)==true){         
             return("Bienvenido, confirme codigo de seguridad");
         }
          
         if(dao.leer(usuario)==true){             
             return("Bienvenido");
         }
         
        return("Datos incorrectos") ;
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length()>1 && nombre.length() <=6);
        
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length()>1 && password.length() <=6);
        
    }
}
