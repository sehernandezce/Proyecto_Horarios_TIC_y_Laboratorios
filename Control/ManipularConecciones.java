package Control;

import DAO.ConexionDAO;
import Entidad.Usuario;
import java.sql.Connection;

public class ManipularConecciones {
    
    ConexionDAO conexionDao = new ConexionDAO();
    
    
    
    public void crearConeccion(Usuario Par){
        conexionDao.crearConeccion(Par);
    }
    
    public Connection getConeccion(){
        return conexionDao.getConnection();
    }
}
