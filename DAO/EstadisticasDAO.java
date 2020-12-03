package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidad.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;


public class EstadisticasDAO {

    private ConexionDAO conexionDao = new ConexionDAO();
    private Connection connection = null;

    public EstadisticasDAO() {
    }

    
    
    public EstadisticasDAO(Connection connection) {
        this.connection = connection;
        this.conexionDao.setConnection(this.connection);
    }

    public void reconection(Usuario par) {
    
        try {
            
            if (connection.isClosed()) {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "¿Se ha perdido la conexión con el servidor, intentar reconectar con el servidor?", "Exit", dialog);
                if (result == 0) {
                    this.connection = this.conexionDao.Reconnection(par.getTipoUsuario());
                    reconection(par);
                } else {
                    JOptionPane.showMessageDialog(null, "El programa se cerrará por falta de conexion con el servidor", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EspaciosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DefaultCategoryDataset  obtenerGrafica_especifico(Usuario par, int tipoEspacio, int mes, int anio) {
        reconection(par);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String fecha=anio+"-"+mes;

        try {
            resultSet = null;            
            statement = this.connection.createStatement();            
            resultSet = statement.executeQuery("Call espacio_especifico_estadistica('^"+fecha+"',"+tipoEspacio+")");
            if (resultSet.next()) {
                   return obtenerData(resultSet,"NOMBRE_ESPACIO");
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error en SQL" + e);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();              
               
            } catch (Exception ex) {

            }
        }
    }
    
    
    public DefaultCategoryDataset  obtenerGrafica_general(Usuario par,int mes, int anio) {
        reconection(par);        
        Statement statement = null;
        ResultSet resultSet = null;
        String fecha=anio+"-"+mes;

        try {
            resultSet = null;           
            statement = this.connection.createStatement();  
            resultSet = statement.executeQuery("Call espacio_general_estadistica('^"+fecha+"')");
            if (resultSet.next()) {
                return obtenerData(resultSet,"NOMBRE_TIPOESPACIO");
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error en SQL" + e);
            return null;
        } finally {
            try {
                resultSet.close();
                statement.close();           
               
            } catch (Exception ex) {

            }
        }
    }
    
      public DefaultCategoryDataset  obtenerData(ResultSet rs,String columna) throws SQLException{
        DefaultCategoryDataset  dataset= new DefaultCategoryDataset ();
        rs.previous();
        while(rs.next()){
            dataset.setValue(Integer.parseInt(rs.getString("Cantidad")), "Espacio", rs.getString(columna));
            
        }
      return dataset;
    }
    
}
