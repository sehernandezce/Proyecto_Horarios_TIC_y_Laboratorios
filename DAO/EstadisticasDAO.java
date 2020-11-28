package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Entidad.Usuario;

public class EstadisticasDAO {

    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";

    private static String DB_USER;
    private static String DB_PASSWD;

    private void seleccionarUser(int tipUser) {

        if (tipUser == 1 || tipUser == 4) {
            this.DB_USER = "UserStandard";
            this.DB_PASSWD = "Us58*uQL";
        } else if (tipUser == 2) {
            this.DB_USER = "horariosdesalastics";
            this.DB_PASSWD = "123456789Qw";
        }
    }

    public int obtenerGrafica(Usuario par, int tipoEspacio, int mes, int anio) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            resultSet = null;
            seleccionarUser(par.getTipoUsuario());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            DB_USER = null;
            DB_PASSWD = null;
            resultSet = statement.executeQuery("SELECT * from SOLICITUDES, ESPACIOS WHERE mesREGEX and ESPACIOS.ID_TIPOESPACIO =" + tipoEspacio + ";");
            if (resultSet.next()) {
                return Integer.valueOf(resultSet.getString(1));
            } else {
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
               
            } catch (Exception ex) {

            }
        }
    }
}

