
package Entidad;

import java.awt.Component;
import java.awt.Frame;
import static java.lang.System.exit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HiloCargando extends Thread{
    private static Thread hilo;
    public boolean suspender; //Suspende un hilo cuando es true
    private boolean finalizar;
    public  static javax.swing.JLabel jlabel=new javax.swing.JLabel();
    private String mensaje="...";
    
    public HiloCargando (){
       
    }
    public HiloCargando (JLabel jlabel2,String mensaje2){       
        this.jlabel=jlabel2;
        this.suspender=true;
        this.finalizar=false;
        this.mensaje=mensaje2;
     
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
              
             while(suspender){
                    System.out.println(mensaje);                    
   
                    jlabel.setText(mensaje);
                    jlabel.updateUI();
                    jlabel.revalidate();
                    jlabel.repaint();                     
                    
                    Thread.sleep(2000);                    
                    wait();
                }
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
       // this.suspender=false;
         notify();
    }

    //Suspender un hilo
    public synchronized void suspenderhilo(String mensaje2){
        this.suspender=true;
        this.mensaje=mensaje2;
    }

    //Renaudar un hilo
    public synchronized void renaudarhilo(String mensaje2){
      //  this.suspender=false;    
      this.mensaje=mensaje2;
         notify();
    }    
 
   
}
