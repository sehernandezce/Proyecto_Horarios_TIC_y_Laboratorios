/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidad.Usuario;
import DAO.EstadisticasDAO;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author brukm
 */
public class GraficarEstadisticas {
    
    private EstadisticasDAO daoEstadisticas = new EstadisticasDAO();
    
    public int graficarGeneral(Usuario user, int mes, int anio){
        return 0;
    }
    
    public void graficarEspecifico (Usuario user, int tipoEspacio, int mes, int anio ) throws IOException{
        
        DefaultPieDataset dataset=daoEstadisticas.obtenerGrafica_especifico(user, tipoEspacio, mes, anio);
        
        JFreeChart chart=ChartFactory.createBarChart("Grafico", "Espacio", "Cantidad", (CategoryDataset) dataset);
        
        int ancho=350;
        int alto=210;
        File F= new File("src\\Graficos\\Grafico_especifico.png");
        ChartUtilities.saveChartAsPNG(F, chart ,ancho,alto);

    }
    
    public int generarGrafica(ResultSet rs){
        return 0;
    }
}
