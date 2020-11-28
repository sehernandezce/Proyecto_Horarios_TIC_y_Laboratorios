 
package Hilos; 
 
import javax.swing.ImageIcon;
import javax.swing.JLabel; 


 
public class HiloCargando extends Thread{  
    
    private static Thread hilo; 
    private boolean suspender; 
    private boolean finalizar; 
    public static javax.swing.JLabel jLCargando; 
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
        jLCargando.setVisible(true);
        this.suspender=true;
        this.hilo.start();   
    } 
     
    @Override 
    public void run() {      
        try {       
     //    synchronized (this) {          
             while(this.suspender){                                      
                    if(giro){                             
                       jLCargando.setIcon(new ImageIcon("src/Imagenes/reloj-de-arena 2.png")); 
                        giro=false;  
                       
                    }else{
                       jLCargando.setIcon(new ImageIcon("src/Imagenes/reloj-de-arena.png"));  
                        giro=true;                            
                    }
                    System.out.println(hilo.getName()+ "  supender: "+this.suspender);
                    Thread.sleep(2000); 
                   // wait(); 
                }
                jLCargando.setVisible(false); 
             
     //          } 
            
        }catch (InterruptedException exc){ 
            System.out.println(hilo.getName()+ "interrumpido."); 
        }         
         
         
    } 
     public void finalizarhilo(){ 
        this.finalizar=true;        
        this.suspender=false; 
        //notify(); 
    } 
        

} 