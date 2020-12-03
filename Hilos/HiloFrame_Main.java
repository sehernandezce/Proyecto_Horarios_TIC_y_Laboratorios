package Hilos;

import GUI.Frame_Main;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloFrame_Main  extends Thread{
    
    private static Thread hilo; 
    private static Frame_Main frame_Main; 
    private String masInfo;
      
    public HiloFrame_Main (){ 
        
    } 
    public void setVariable (Frame_Main  frame_Main){        
        this.frame_Main=frame_Main;              

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
            case "solicitar_Espacio":
            {
                try {
                    frame_Main.solicitar_Espacio(masInfo);
                } catch (SQLException ex) {
                    Logger.getLogger(HiloFrame_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
            }
               
            case "verificarIngresoSolicitud":
            {
                 frame_Main.verificarIngresoSolicitud();
                break;
            }
            case "guardarCamContrasenia":
            {
                frame_Main.guardarCamContrasenia();
                break;
            }
            case "cambiarEstado":
            {
                try {
                    frame_Main.cambiarEstado(masInfo);
                } catch (Exception ex) {
                    Logger.getLogger(HiloFrame_Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "mostrarPorTipEspacio":
            {
                frame_Main.mostrarPorTipEspacio();
                break;
            }
            case "mostrarPorEspacios":
            {
                frame_Main.mostrarPorEspacios();
                break;
            }
            case "llenarTabla_solicitudes":
            {
            try {
                frame_Main.llenarTabla_solicitudes(masInfo);
            } catch (SQLException ex) {
                Logger.getLogger(HiloFrame_Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "camCorreoNotificar":
            {
                frame_Main.camCorreoNotificar();
                break;
            }
            case "camCodig":
            {
                frame_Main.camCodig();
                break;
            }
        }
         
    } 
 
}
