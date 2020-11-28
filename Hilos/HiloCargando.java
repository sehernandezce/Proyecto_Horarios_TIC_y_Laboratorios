 
package Hilos; 
 
import javax.swing.ImageIcon;
import javax.swing.JLabel; 
import GUI.Frame_Main;
 
public class HiloCargando extends Thread{ 
    private static Thread hilo; 
    private boolean suspender; 
    private boolean finalizar; 
    public javax.swing.JLabel jLCargando; 
    private boolean giro=false;
    public HiloCargando (){ 
        
    } 
    public void setVariable (JLabel jLCargando){        
        this.jLCargando=jLCargando; 
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
         synchronized (this) { 
           jLCargando.setVisible(true);
             while(suspender){                                      
                   
                    if(giro){                       
                       jLCargando.setIcon(new ImageIcon("src/Imagenes/reloj-de-arena 2.png")); 
                       jLCargando.setText("tosde");
                       giro=false;        
                        System.out.println("Giro 1 "+giro+" es visible: "+jLCargando.isVisible());
                       
                    }else{
                       jLCargando.setIcon(new ImageIcon("src/Imagenes/reloj-de-arena.png"));  
                        giro=true;
                        jLCargando.setText("tosde2");
                         System.out.println("Giro 2 "+giro+" es visible: "+jLCargando.isVisible());     
                    }
                    jLCargando.repaint();
                    jLCargando.revalidate(); 
                     jLCargando.updateUI(); 
                    Thread.sleep(2000); 
                   wait(); 
                }
                jLCargando.setVisible(false); 
             
               } 
            
        }catch (InterruptedException exc){ 
            System.out.println(hilo.getName()+ "interrumpido."); 
        }         
         
         
    } 
 
    public synchronized void finalizarhilo(){ 
        this.finalizar=true;        
        this.suspender=false; 
         notify(); 
    } 
 
     public synchronized void suspenderhilo(){ 
        this.suspender=true;     
    } 
 
     public synchronized void renaudarhilo(){ 
      this.suspender=false;     
      notify(); 
    }          
     
   public synchronized void girar(){    
      notify(); 
    }   
    
} 