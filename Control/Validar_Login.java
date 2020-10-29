 
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;


public class Validar_Login {
    private UsuarioDAO dao = new UsuarioDAO();
   
    public  Validar_Login(){
        
    }
    
    public int verificarLogin(Usuario usuario){
        if (!verificarLongitudNombre (usuario.getNombreusuarioInstitucional())){
            return (-1); //Longitud nombre incorrecta == -1 
        }
         if (!verificarLongitudPassword (usuario.getContrasenia())){
            return(-2); //Longitud contraseña incorrecta == -2
        }
         
        return(dao.leer(usuario)); //Bienvenido > 0, -3 si hay un error en la BD y 0 si el usuario no existe
         
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length()>1 && nombre.length() <=20);
        
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length()>8 && password.length()<= 20);
    }
}
