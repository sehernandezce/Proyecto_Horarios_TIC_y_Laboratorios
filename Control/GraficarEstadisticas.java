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

/**
 *
 * @author brukm
 */
public class GraficarEstadisticas {
    
    private EstadisticasDAO daoEstadisticas = new EstadisticasDAO();
    
    public int graficarGeneral(Usuario user, int mes, int anio){

    }
    
    public int graficarEspecifico (Usuario user, int tipoEspacio, int mes, int anio ){
        daoEstadisticas.obtenerGrafica(user, tipoEspacio, mes, anio );
;
    }
    public int generarGrafica(ResultSet rs){
        
    }
}
