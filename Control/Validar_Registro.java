
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
            if(!dao.VerificarCode(codigo)){
                 return -5;//"Codigo incorrecto"
            }else{
             usuario.setNombreusuarioInstitucional(name);
             usuario.setContrasenia(pass1); 
             usuario.setTipoUsuario(tipoUsuario);
             if(dao.crear(usuario)){
                 return 1; 
             }else{
                 return -6;
             }
             
            }
               
         }else {
             usuario.setNombreusuarioInstitucional(name);
             usuario.setContrasenia(pass1);                
             usuario.setTipoUsuario(tipoUsuario);       
              if(dao.crear(usuario)){
                 return 1;  //"Usuario registrado"
             }else{
                 return -6;
             }
        
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
        }else if(!(password.matches("[0-9]*")||!password.matches("[a-zA-Z]*"))){
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
     
      public int camPass(String U, String pass1, String pass2, String cod) throws Exception{
         if(!verificarLongitudNombre(U)){
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
        } else if (!verificarLongitudCode(cod)){
            return(-5);//"Codigo incorrecto "
        }else if(dao.VerificarCode(cod,U)){           
              usuario.setNombreusuarioInstitucional(U);
              usuario.setContrasenia(pass1);              
               if(dao.actualizarPASS(usuario)){
                  return 1;  //"Usuario registrado"
              }else{
                  return -6;
              }                         
        }else{
             return -5;
        }
        
         
    }
     
    public boolean verificarLongitudCode(String cod)
         {
             return (cod.length()>3 && cod.length()<= 6);
         }
}
