 
package Control;

import DAO.UsuarioDAO;
import Entidad.Correo;
import Entidad.Usuario;
import java.util.Random;


public class Validar_Login {
    private UsuarioDAO dao = new UsuarioDAO();    
    public  Validar_Login(){
        
    }
    
    public int verificarLogin(Usuario usuario) throws Exception{
        if (!verificarLongitudNombre (usuario.getNombreusuarioInstitucional())){
            return (-1); //Longitud nombre incorrecta == -1 
        }
         if (!verificarLongitudPassword (usuario.getContrasenia())){
            return(-2); //Longitud contraseña incorrecta == -2
        }
     
         return(dao.leer(usuario)); //Bienvenido > 0, en otro caso retorna 0= usuario no existe
         
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length()>4 && nombre.length() <=20);
        
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length()>8 && password.length()<= 20);
    }
    
     public int existeUser(String u) throws Exception{
        if (!verificarLongitudNombre (u)){           
            return (-1); //Longitud nombre incorrecta 
        }else if(dao.existir(u).equals("false")){
            return (-1);
        }else{
          return enviarCod(u);  
        }      
       
    }
     
       public int enviarCod(String u) throws Exception{
         Random aleatorio = new Random(System.currentTimeMillis());
        aleatorio.setSeed(System.currentTimeMillis()); 
        String cod=String.valueOf(aleatorio.nextInt(99999)+1001); 
        System.out.println("enviarcod");
           Correo correo= new Correo();
            correo.setAsunto("Restablezca la contraseña. Horarios de salasTIC's y laboratorios");
            correo.setMensaje("Estimado/a <b>u</b>,<br> ¿Ha olvidado la contraseña?<br> Restablesca su contraseña ingresando el código: "+cod
                                +"<br>El código es valido durante 24 horas y solo podra ser usado una vez. No se podran generar más codigo hasta pasar 24 horas o haber usado este código."+"<br> Si no desea cambiar la contraseña o no lo ha solicitado, ignore este mensaje y bórrelo. Gracias.<br>");
            correo.setCorreoReceptor(u + "@unal.edu.co");
            correo.setPasswordRemitente("iodU78+*OpH");        
          System.out.println("correo");         
         return dao.AgreCod(u, correo, cod);
    }
    
}
