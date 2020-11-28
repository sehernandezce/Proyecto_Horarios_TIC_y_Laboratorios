package Control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidad.Usuario;
import DAO.EstadisticasDAO;

public class GraficarEstadisticas {
    
    private EstadisticasDAO daoEstadisticas = new EstadisticasDAO();
    
    public int graficarGeneral(Usuario user, int mes, int anio){
        return 0;
    }
    
    public int graficarEspecifico (Usuario user, int tipoEspacio, int mes, int anio ){
        return daoEstadisticas.obtenerGrafica(user, tipoEspacio, mes, anio );

    }
    public int generarGrafica(ResultSet rs){
        return 0;
    }
}
