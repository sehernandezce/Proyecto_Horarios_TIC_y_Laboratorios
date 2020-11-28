package Hilos;

import GUI.Frame_Login;
 
public class HiloGUI extends Thread{ 
    private static Thread hilo; 
    private boolean suspender; 
    private boolean finalizar;  
    public static HiloCargando hiloCargando = new HiloCargando();
     
    public HiloGUI (){        
        this.suspender=true; 
        this.finalizar=false;   
    } 
    public void Iniciar(String nombre, HiloCargando hiloCargando2){        
        this.hilo=new Thread(this,nombre); 
        this.hiloCargando=hiloCargando2;
        this.hilo.start();   
    } 
    @Override 
    public void run() {       
        Frame_Login frame_Login=new Frame_Login();
        frame_Login.setHiloMain2(this);
        frame_Login.setVisible(true);
         try { 
         synchronized (this) {
             while(suspender){ 
                     wait(); 
                   } 
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
  
    
} 
