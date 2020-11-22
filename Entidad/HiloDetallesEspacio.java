package Entidad;

import GUI.Frame_DetallesEspacio;
import GUI.Frame_Main;
import java.awt.Component;
import java.awt.Frame;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HiloDetallesEspacio extends Thread{
    private static Thread hilo;
    public boolean suspender; //Suspende un hilo cuando es true
    private boolean finalizar;
    private static  Frame_DetallesEspacio frame_DetallesEspacio;   
    
    public HiloDetallesEspacio (){
       
    }
    public HiloDetallesEspacio (Frame_DetallesEspacio frame_DetallesEspacio2){       
        this.frame_DetallesEspacio = new Frame_DetallesEspacio ();
        this.frame_DetallesEspacio=frame_DetallesEspacio2;
        this.suspender=true;
        this.finalizar=false;
     
    }
    public void Iniciar(String nombre){       
        this.hilo=new Thread(this,nombre);
        this.hilo.start();  
    }
    
    @Override
    public void run() {
        System.out.println(hilo.getName()+ " iniciando.");
        try {
           //  hilo.sleep(400);
         synchronized (this) {
         
          System.out.println(suspender);          
                    System.out.println("Entro");  
                    frame_DetallesEspacio.guardar();  
                    Thread.sleep(1000);                    
                    //wait();
                
               System.out.println(suspender); 
            
               }
            // jlabel.setText("");
        }catch (InterruptedException exc){
            System.out.println(hilo.getName()+ "interrumpido.");
        } catch (SQLException ex) {
            Logger.getLogger(HiloDetallesEspacio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        
    }
    
     //Pausar el hilo
    public synchronized void finalizarhilo(){
        this.finalizar=true;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        this.suspender=false;
         notify();
    }

    //Suspender un hilo
    public synchronized void suspenderhilo(){
        this.suspender=true;
       
    }

    //Renaudar un hilo
    public synchronized void renaudarhilo(){
      //  this.suspender=false;    
      
         notify();
    }    
 
   
}
