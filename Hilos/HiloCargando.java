 
package Hilos; 
 
import javax.swing.ImageIcon;
import javax.swing.JLabel; 


 
public class HiloCargando extends Thread{  
    
    private static Thread hilo; 
    private boolean suspender; 
    public static javax.swing.JLabel jLCargando; 
    private boolean giro=false;
    public HiloCargando (){ 
        
    } 
    public void setVariable (JLabel jLCargando){        
        this.jLCargando=jLCargando;               
        this.suspender=true;     
      
    } 
    
    public void Iniciar(String nombre){        
        this.hilo=new Thread(this,nombre);
        this.jLCargando.setVisible(true);
        this.suspender=true;
        this.hilo.start();   
    } 
     
    @Override 
    public void run() {      
        try {       
     while(this.suspender){                                      
                    if(giro){                             
                       jLCargando.setIcon(new ImageIcon("src/Imagenes/reloj-de-arena 2.png")); 
                        giro=false;  
                       
                    }else{
                       jLCargando.setIcon(new ImageIcon("src/Imagenes/reloj-de-arena.png"));  
                        giro=true;                            
                    }                   
                    Thread.sleep(1700);                  
                }
                
                jLCargando.setVisible(false);                  
        }catch (InterruptedException exc){ 
            System.out.println(hilo.getName()+ "interrumpido."); 
        }         
         
         
    } 
     public void finalizarhilo(){  
        this.suspender=false; 
    } 
        

} 