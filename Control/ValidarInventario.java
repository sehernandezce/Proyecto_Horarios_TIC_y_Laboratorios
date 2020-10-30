
package Control;

import DAO.InventariosDAO;
import Entidad.Usuario;
import java.sql.SQLException;

public class ValidarInventario {
    
     InventariosDAO inventariosDAO= new InventariosDAO();
     
      public String[][] llenarMatrizInv(int idEspacio,Usuario par) throws SQLException{
        return inventariosDAO.leer(par, idEspacio);        
    
      }
    
    
}
