
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class Validar_Registro {
    
    private UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario =new Usuario ();
    
    public Validar_Registro(){
        
    }
    
    public String verificarRegistro(String nombre, String password, String rePassword, int tipoUsuario){
        if(!verificarLongitudNombre(nombre)){
            return("Longitud nombre incorreta");
        }
        else if (!verificarLongitudPassword(password)){
            return("Longitud contraseña incorreta");
        }
         else if (!verificarContrasenias(password,rePassword)){
            return("Las contraseñas no coinciden");
        }
         else {
             usuario.setNombreusuarioInstitucional(nombre);
             usuario.setContrasenia(password);
             usuario.setTipoUsuario(tipoUsuario);
             dao.crear(usuario);
             return "Usuario registrado";
         }    
        
    }
            
    public boolean verificarContrasenias( String password, String rePassword){
        return password.equals(rePassword);
    }
    
    public boolean verificarLongitudNombre(String nombre)
    {
        return (nombre.length()>1 && nombre.length()<= 6);
    }  
    
     public boolean verificarLongitudPassword(String password)
    {
        return (password.length()>1 && password.length()<= 6);
    }
    
}
