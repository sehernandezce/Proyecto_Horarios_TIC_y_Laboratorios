package Control;


import Entidad.Usuario;
import DAO.EstadisticasDAO;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficarEstadisticas {
    
    private EstadisticasDAO daoEstadisticas = new EstadisticasDAO();
    
    public void graficarGeneral(Usuario user, int mes, int anio) throws IOException{
       DefaultCategoryDataset dataset=daoEstadisticas.obtenerGrafica_general(user, mes, anio);
         //se esta combinando el data set de una grafica de pie con una grafica barchart
        JFreeChart chart=ChartFactory.createBarChart("Grafico espacios", "Espacios", "solicitudes", dataset, PlotOrientation.VERTICAL, false, false, false);
        //Pasar a grafica xychart
        int ancho=370;
        int alto=330;
        File F= new File("src\\Graficos\\Grafico_general.png");
        ChartUtilities.saveChartAsPNG(F, chart ,ancho,alto);
    }
    
    public void graficarEspecifico (Usuario user, int tipoEspacio, int mes, int anio ) throws IOException{
        
        DefaultCategoryDataset dataset=daoEstadisticas.obtenerGrafica_especifico(user, tipoEspacio, mes, anio);
        //se esta combinando el data set de una grafica de pie con una grafica barchart
        JFreeChart chart=ChartFactory.createBarChart("Grafico por "+tipo_espacio(tipoEspacio), "Espacios", "solicitudes", dataset, PlotOrientation.VERTICAL, false, false, false);
        //Pasar a grafica xychart
        int ancho=370;
        int alto=330;
        File F= new File("src\\Graficos\\Grafico_especifico.png");
        ChartUtilities.saveChartAsPNG(F, chart ,ancho,alto);

    }
    
   public String tipo_espacio(int tipo_espacio){
       if(tipo_espacio==1){
           return "Laboratorios";
       }
       if(tipo_espacio==2){
           return "Salas de computadores";
       }
       if(tipo_espacio==3){
           return "Salas de reuniones";
       }
       if(tipo_espacio==4){
           return "Auditorios";
       }
       return null;
   }
}
