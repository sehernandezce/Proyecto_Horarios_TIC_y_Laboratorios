/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.EspaciosDAO.DB_URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidad.Usuario;
import DAO.UsuarioDAO;

/**
 *
 * @author brukm
 */
public class EstadisticasDAO {
     static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";

    private static String DB_USER;
    private static String DB_PASSWD;

    private void seleccionarUser(int tipUser){
        
        if(tipUser==1 ||  tipUser==2){
            this.DB_USER="UserStandard";
            this.DB_PASSWD="Us58*uQL";
        }else if(tipUser==2){
            this.DB_USER="horariosdesalastics";
            this.DB_PASSWD="123456789Qw";
        }
        
        public int obtenerGrafica(int tipoEspacio, String mes, String anio ){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;           
        
                try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            DB_USER= null;
            DB_PASSWD=null;
            //VALUES ('453', '1', '2', 'lab prueba', '123', '1', '312');
            resultSet = statement.executeQuery("SELECT * from SOLICITUDES, ESPACIOS WHERE mesREGEX and ESPACIOS.ID_TIPOESPACIO ="+ tipoEspacio + ";");
            if(resultSet.next()){               
                return Integer.valueOf(resultSet.getString(1));
            }else{
                return -4;
            }
        } catch (Exception e) {
            System.out.println("Error en SQL" + e);
            return -4;
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                //return null;
            } catch (Exception ex) {

                }
            }
        }
    }
}
