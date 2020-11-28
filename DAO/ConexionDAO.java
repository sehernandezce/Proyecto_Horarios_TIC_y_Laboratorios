/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConexionDAO {

    private Connection connection = null;

    static final String DB_URL
            = "jdbc:mysql://database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com:3306/Horarios_Tics_y_Laboratorios"; //Endpoint
    static final String DB_DRV
            = "com.mysql.jdbc.Driver";

    private static String DB_USER;
    private static String DB_PASSWD;

    public Connection crearConeccion(Usuario par) {
        seleccionarUser(par.getTipoUsuario());
        try {
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }

    public void Reconnection(int tipoUsuario){
        
        try {
            System.out.println("conexión: "+this.connection.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        seleccionarUser(tipoUsuario);
        try {
            if(this.connection.isClosed()){
                this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            }
        } catch (SQLException ex) {
            try {
                this.connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }
    
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    

    public void cerrarConeccion() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void seleccionarUser(int tipUser) {

        if (tipUser == 1 || tipUser == 4) {
            this.DB_USER = "UserStandard";
            this.DB_PASSWD = "Us58*uQL";
        } else if (tipUser == 2) {
            this.DB_USER = "UserCoordinator";
            this.DB_PASSWD = "uC102*lPg";
        } else if(tipUser == -10){
            this.DB_USER = "SeeTableUser";
            this.DB_PASSWD = "ISsRD1*y";
        }
    }
}
