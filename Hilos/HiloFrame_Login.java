package Hilos;


import GUI.Frame_Login;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloFrame_Login extends Thread{
        
    private static Thread hilo; 
    private static Frame_Login frame_Login; 
    private String masInfo;
      
    public HiloFrame_Login (){ 
        
    } 
    public void setVariable (Frame_Login  frame_Login){        
        this.frame_Login=frame_Login;              

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
            case "logIn":
            {
                frame_Login.logIn();
                break;
            }
            case "forgetPass":
            {
            try {
                frame_Login.forgetPass();
            } catch (Exception ex) {
                Logger.getLogger(HiloFrame_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "CamPass":
            {
            try {
                frame_Login.CamPass();
            } catch (Exception ex) {
                Logger.getLogger(HiloFrame_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "logUp":
            {
                frame_Login.logUp();                
                break;
            }    
        }
         
    }
}
