 
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;


public class Validar_Login {
    private UsuarioDAO dao = new UsuarioDAO();
    private ContraseniaHasheada contraseniahasheada = new ContraseniaHasheada(); 
    public  Validar_Login(){
        
    }
    
    public int verificarLogin(Usuario usuario) throws Exception{
        if (!verificarLongitudNombre (usuario.getNombreusuarioInstitucional())){
            return (-1); //Longitud nombre incorrecta == -1 
        }
         if (!verificarLongitudPassword (usuario.getContrasenia())){
            return(-2); //Longitud contraseña incorrecta == -2
        }
 //       usuario.setContrasenia(contraseniahasheada.getSaltedHash(usuario.getContrasenia()));

        return(dao.leer(usuario)); //Bienvenido > 0, en otro caso retorna 0= usuario no existe
         
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length()>1 && nombre.length() <=20);
        
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length()>8 && password.length()<= 20);
    }
}
