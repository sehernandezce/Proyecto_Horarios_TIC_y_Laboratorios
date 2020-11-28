package GUI;
import Hilos.HiloCargando;
import Hilos.HiloGUI;

public class Run_GUI {   
    private static HiloGUI hiloGUI = new HiloGUI();
    private static HiloCargando hiloCargando = new HiloCargando();
    public static void main(String [] args){
          hiloGUI.Iniciar("GUI",hiloCargando);          
    }
}
