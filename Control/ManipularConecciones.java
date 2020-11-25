/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.ConexionDAO;
import Entidad.Usuario;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class ManipularConecciones {
    
    ConexionDAO conexionDao = new ConexionDAO();
    
    
    
    public void crearConeccion(Usuario Par){
        conexionDao.crearConeccion(Par);
    }
    
    public Connection getConeccion(){
        return conexionDao.getConnection();
    }
}
