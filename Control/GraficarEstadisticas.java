package Control;


import Entidad.Usuario;
import DAO.EstadisticasDAO;
import java.awt.Font;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficarEstadisticas {
    
    private ManipularConecciones conexion = null;
    
    public GraficarEstadisticas(ManipularConecciones conexion) {
            this.conexion = conexion;
            daoEstadisticas = new EstadisticasDAO(this.conexion.getConeccion());
    }
        
    private EstadisticasDAO daoEstadisticas;
    
    public JFreeChart graficarGeneral(Usuario user, int mes, int anio) throws IOException{
        Font font = new Font("Segoe UI", Font.PLAIN, 10);
        DefaultCategoryDataset dataset=daoEstadisticas.obtenerGrafica_general(user, mes, anio);
       JFreeChart chart=ChartFactory.createBarChart("Grafico espacios", "Espacios", "solicitudes", dataset, PlotOrientation.VERTICAL, false, true, true);
        CategoryPlot p = chart.getCategoryPlot(); 
        ValueAxis axis = p.getRangeAxis();
        axis.setTickLabelFont(font);        
        CategoryAxis axis2 = p.getDomainAxis();
        axis2.setTickLabelFont(font);      
       return chart;
    }
    
    public JFreeChart graficarEspecifico (Usuario user, int tipoEspacio, int mes, int anio ) throws IOException{
        Font font = new Font("Segoe UI", Font.PLAIN, 10);        
        DefaultCategoryDataset dataset=daoEstadisticas.obtenerGrafica_especifico(user, tipoEspacio, mes, anio);
        JFreeChart chart=ChartFactory.createBarChart("Grafico por "+tipo_espacio(tipoEspacio), "Espacios", "solicitudes", dataset, PlotOrientation.VERTICAL, false, true, true);
        CategoryPlot p = chart.getCategoryPlot(); 
        ValueAxis axis = p.getRangeAxis();
        axis.setTickLabelFont(font);        
        CategoryAxis axis2 = p.getDomainAxis();
        axis2.setTickLabelFont(font);        
        return chart;
    }
    
   public String tipo_espacio(int tipo_espacio){
       if(tipo_espacio==1){
           return "Laboratorios";
       }
       if(tipo_espacio==2){
           return "Salas de reuniones";
       }
       if(tipo_espacio==3){
           return "Salas de computadores";
       }
       if(tipo_espacio==4){
           return "Auditorios";
       }
       return null;
   }
}
