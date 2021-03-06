
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;


public class Validar_Registro {
    
    private ManipularConecciones conexion = null;

    public Validar_Registro(ManipularConecciones conexion) {
        this.conexion = conexion;
        dao = new UsuarioDAO(conexion.getConeccion());
    }

    
    private UsuarioDAO dao ;    
    Usuario usuario =new Usuario (); 
    
    
    public int verificarRegistro(String name, String pass1, String pass2, int tipoUsuario, String codigo) throws Exception{
        if(!verificarLongitudNombre(name)){
            return(-1);
        }
        else if (!verificarLongitudPassword(pass1)){
            return(-2); 
        }
         else if (!verificarContrasenias(pass1,pass2)){
            return(-3);
        }
         else if (!verificarSeguridadContrasenias(pass1)){
            return(-4);
        }
         else if(tipoUsuario==2){
            if(!dao.VerificarCode(codigo)){
                 return -5;
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
                 return 1; 
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
            return(-1);
        }
        else if (!verificarLongitudPassword(pass1)){
            return(-2); 
        }
         else if (!verificarContrasenias(pass1,pass2)){
            return(-3);
        }
         else if (!verificarSeguridadContrasenias(pass1)){
            return(-4);
        } else if (!verificarLongitudCode(cod)){
            return(-5);
        }else if(dao.VerificarCode(cod,U)){           
              usuario.setNombreusuarioInstitucional(U);
              usuario.setContrasenia(pass1);              
               if(dao.actualizarPASS(usuario)){
                  return 1; 
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
    
    public int cambiarcontrasenia(Usuario u, String pass1, String pass2) throws Exception{
        if(!verificarLongitudNombre(u.getNombreusuarioInstitucional())){
            return(-1); 
        }
        else if(verificarContrasenias(u.getContrasenia(),pass1)){
            return(-6);
        }
        else if (!verificarLongitudPassword(u.getContrasenia())){
            return(-2);
        }else if (!verificarLongitudPassword(pass1)){
            return(-2); 
        }
         else if (!verificarContrasenias(pass1,pass2)){
            return(-3);
        }else if (!verificarSeguridadContrasenias(pass1)){
            return(-4);
        }else if(dao.leer(u)<=0){
             return(0);
        }else{
            u.setContrasenia(pass1);
             if(dao.actualizarPASS(u)){
                  return 1;  
              }else{
                  return -5;
              }  
        }
    
    }
    
    
    public int cambiarCod(Usuario u, String codigo) throws Exception{
        
        if(u.getTipoUsuario()!=2){
             return(-6);
        }
        else if(!verificarLongitudNombre(u.getNombreusuarioInstitucional())){
            return(-1); 
        }
        else if (!verificarLongitudPassword(u.getContrasenia())){
            return(-2);
        }else if (!verificarLongitudPassword(codigo)){
            return(-3); 
        } else if (!verificarSeguridadContrasenias(codigo)){
            return(-4);
        }else if(dao.leer(u)<=0){
             return(0);
        }else{
            Usuario code=new Usuario();
            code.setNombreusuarioInstitucional("UserCode");
            code.setContrasenia(codigo);
             if(dao.actualizarPASS(code)){
                  return 1;  
              }else{
                  return -5;
              }  
        }
        
    }
    
    public int camCorreoNot(Usuario u, String correo, String pass, String pass2) throws Exception{
        if(u.getTipoUsuario()!=2){
             return(-6);
        }
        else if(!verificarLongitudNombre(u.getNombreusuarioInstitucional())){
            return(-1); 
        }
        else if (!verificarLongitudPassword(u.getContrasenia())){
            return(-2); 
        }else if (!verificarContrasenias(pass,pass2)){
            return(-3);
        }else if(correo.length()==0 || pass.length()==0){
            return(-4);
        }else if(dao.leer(u)<=0){
             return(0);
        }else{
            Usuario corre=new Usuario();
            corre.setNombreusuarioInstitucional(correo);
            corre.setContrasenia(pass);           
            if(dao.actualizarCorreoNot(corre)){
                  return 1;  
              }else{
                  return -5;
              }
        }
    }
    
    public void crearCodC() throws Exception{
        usuario.setNombreusuarioInstitucional("UserCode");
        usuario.setContrasenia("koUyrt90*65");                
        usuario.setTipoUsuario(3);       
        dao.crear(usuario);  
        }    
  
    
    }
