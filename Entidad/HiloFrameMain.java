/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;


import GUI.Frame_Main;
import java.awt.Component;
import java.awt.Frame;
import static java.lang.System.exit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HiloFrameMain extends Thread{
    private static Thread hilo;
    public boolean suspender; //Suspende un hilo cuando es true
    private boolean finalizar;
    private static  Frame_Main frame_Main;   
    
    public HiloFrameMain (){
       
    }
    public HiloFrameMain (Frame_Main frame_Main2){       
        this.frame_Main = new Frame_Main ();
        this.frame_Main=frame_Main2;
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
                    frame_Main.verificarIngresoSolicitud();    
                    Thread.sleep(1000);                    
                    //wait();
                
               System.out.println(suspender); 
            
               }
            // jlabel.setText("");
        }catch (InterruptedException exc){
            System.out.println(hilo.getName()+ "interrumpido.");
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