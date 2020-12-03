package Control;

import DAO.ConexionDAO;
import Entidad.Usuario;
import java.sql.Connection;

public class ManipularConecciones {
    
    ConexionDAO conexionDao = new ConexionDAO();
    
    
    public void verificarConexion(int tipoUsuario){
        this.conexionDao.Reconnection(tipoUsuario);
    }
    
    public void crearConeccion(Usuario Par){
        conexionDao.crearConeccion(Par);
    }
    
    public Connection getConeccion(){
        return conexionDao.getConnection();
    }
}
