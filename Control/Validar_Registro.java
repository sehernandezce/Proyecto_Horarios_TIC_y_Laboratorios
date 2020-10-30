
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class Validar_Registro {
    
    private UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario =new Usuario ();
    
    public Validar_Registro(){
        
    }
    
    public int verificarRegistro(String name, String pass1, String pass2, int tipoUsuario, String codigo){
        if(!verificarLongitudNombre(name)){
            return(-1); // "Longitud nombre incorreta"
        }
        else if (!verificarLongitudPassword(pass1)){
            return(-2); // "Longitud contraseña incorreta"
        }
         else if (!verificarContrasenias(pass1,pass2)){
            return(-3);//"Las contraseñas no coinciden"
        }
         else if (!verificarSeguridadContrasenias(pass1)){
            return(-4);//"La contraseña no es segura. Debe tener al menos un numero, una mayuscula y una minuscula "
        }else if(tipoUsuario == 2){
             int a=codigo.hashCode();
            if(!dao.VerificarCode(a)){
                 return -5;//"Codigo incorrecto"
            }else{
             usuario.setNombreusuarioInstitucional(name);
             usuario.setContrasenia(String.valueOf(pass1.hashCode())); 
             usuario.setTipoUsuario(tipoUsuario);
             dao.crear(usuario);
             return 1; 
            }
               
         }else {
             usuario.setNombreusuarioInstitucional(name);
             usuario.setContrasenia(String.valueOf(pass1.hashCode())); 
             usuario.setTipoUsuario(tipoUsuario);
             dao.crear(usuario);
             return 1; //"Usuario registrado"
         }    
        
    }
            
    public boolean verificarContrasenias( String password, String rePassword){
       return password.equals(rePassword);
    }
    
    public boolean verificarSeguridadContrasenias( String password){
        
        if(password.equals(password.toUpperCase())){
            return false;
        }else if(password.equals(password.toLowerCase())){
             return false;
        }else if(isNumeric(password)){
             return false;
        }
        return true;
    }
    
    public boolean verificarLongitudNombre(String nombre)
    {
        return (nombre.length()>4 && nombre.length()<= 20);
    }  
    
     public boolean verificarLongitudPassword(String password)
    {
        return (password.length()>8 && password.length()<= 20);
    }
    
     public boolean isNumeric(String cadena) {

        try {
            Integer.parseInt(cadena);
           return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }

    }
     
    
}
