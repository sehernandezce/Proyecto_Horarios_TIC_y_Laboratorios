package Hilos;

import GUI.Frame_DetallesEspacio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloFrame_DetallesEspacio extends Thread{
  
    
    private static Thread hilo; 
    private static Frame_DetallesEspacio frame_DetallesEspacio; 
    private String masInfo;
      
    public HiloFrame_DetallesEspacio (){ 
        
    } 
    public void setVariable (Frame_DetallesEspacio  frame_DetallesEspacio){        
        this.frame_DetallesEspacio=frame_DetallesEspacio;              

    } 
    public void Iniciar(String nombreMetodo, String masInfo){        
        this.hilo=new Thread(this,nombreMetodo);       
        this.masInfo=masInfo;
        this.hilo.start();   
    } 
     
    @Override 
    public void run() {        
        String name=hilo.getName();        
        switch(name){
            case "guardar":
            {
            try {
                frame_DetallesEspacio.guardar();
            } catch (SQLException ex) {
                Logger.getLogger(HiloFrame_DetallesEspacio.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }

        }
         
    }
}
