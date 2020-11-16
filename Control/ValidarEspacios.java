 
package Control;

import DAO.UsuarioDAO;
import DAO.EspaciosDAO;
import Entidad.Espacio;
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
     
     public String[][] llenarMatriz_horas(int id_espacio,String fecha,Usuario par, int day) throws SQLException{
       return espacioDao.leerHoras_espacios(par, id_espacio, fecha,day);
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
    
    public Espacio BuscarInfoEspacio(Usuario par, int idEspacio){
        return espacioDao.leerunEspacio(par, idEspacio);
    }
    
    public int ValidarInfoEspacio(Usuario par, Espacio esp){
        
        if(par.getTipoUsuario()!=2){
            return -5;
        }else if(!verificarLongitudName(esp.getNombre_espacio())){
            return -8;
        }else if (!verificarLongitudName(esp.getCorreo_encargado())){
            return -6;
        }else{
            esp.setNombre_tipoespacio(String.valueOf(AsignartipEsp(esp.getNombre_tipoespacio())));
            return espacioDao.ActualizarinfoEspacio(par,esp); 
        }     
        
    }
    
      private boolean verificarLongitudName (String nombre){
        return (nombre.length()>4 && nombre.length() <=20);        
    }
    public int borrarEspacio(Usuario par, String idEspacio){
        if(par.getTipoUsuario()!=2){
             return -3;
        }else{
           return espacioDao.borrarEspacio(par,idEspacio);    
        }
               
    }
    public boolean verificaExistencia(Usuario par, Espacio esp) throws SQLException{
    //Espacio espacio = new Espacio();
        boolean resultado = false;
        if (espacioDao.buscarEspacio(par, esp) == 0) {
            return false;
        } else {
            
            System.out.print(resultado);
            return true;
        }
    }
}
