
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
/*librerías de seguridad:*/
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;


public class Validar_Registro {
    
    private UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario =new Usuario ();
    private ContraseniaHasheada contraseniahasheada = new ContraseniaHasheada(); 
    
    public Validar_Registro(){
        
    }
    
    public int verificarRegistro(String name, String pass1, String pass2, int tipoUsuario, String codigo) throws Exception{
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
        }
         else if(tipoUsuario==2){
            String hasheado = contraseniahasheada.getSaltedHash(codigo);
            
            if(!dao.VerificarCode(hasheado)){
                 return -5;//"Codigo incorrecto"
            }else{
             usuario.setNombreusuarioInstitucional(name);
             usuario.setContrasenia(contraseniahasheada.getSaltedHash(pass1)); 
             usuario.setTipoUsuario(tipoUsuario);
             dao.crear(usuario);
             return 1; 
            }
               
         }
         else {
             usuario.setNombreusuarioInstitucional(name);
             usuario.setContrasenia(contraseniahasheada.getSaltedHash(pass1)); 
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
