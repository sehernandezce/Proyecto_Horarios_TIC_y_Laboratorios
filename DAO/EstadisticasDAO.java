package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidad.Usuario;
import DAO.UsuarioDAO;
import java.sql.SQLException;
import org.jfree.data.general.DefaultPieDataset;

public class EstadisticasDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";

    private static String DB_USER;
    private static String DB_PASSWD;

    private void seleccionarUser(int tipUser) {

        if (tipUser == 1 ) {
            this.DB_USER = "UserStandard";
            this.DB_PASSWD = "Us58*uQL";
        } else if (tipUser == 2 || tipUser == 4) {
            this.DB_USER = "horariosdesalastics";
            this.DB_PASSWD = "123456789Qw";
        }
    }

    public DefaultPieDataset  obtenerGrafica_especifico(Usuario par, int tipoEspacio, int mes, int anio) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String fecha=anio+"-"+mes;

        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            DB_USER = null;
            DB_PASSWD = null;
            //VALUES ('453', '1', '2', 'lab prueba', '123', '1', '312');
            resultSet = statement.executeQuery("Call espacio_especifico_estadistica('^"+fecha+"',"+tipoEspacio+")");
            if (resultSet.next()) {
                return obtenerData_especifico(resultSet);
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
                connection.close();
               
            } catch (Exception ex) {

            }
        }
    }
    
    public DefaultPieDataset obtenerData_especifico(ResultSet rs) throws SQLException{
        DefaultPieDataset dataset= new DefaultPieDataset();
        while(rs.next()){
            dataset.setValue(rs.getString("NOMBRE_ESPACIO"),Integer.parseInt(rs.getString("Cantidad")));
        }
      return dataset;
    }
    
}

 