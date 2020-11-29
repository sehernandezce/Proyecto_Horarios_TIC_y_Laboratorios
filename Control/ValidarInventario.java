package Control;

import DAO.InventariosDAO;
import Entidad.Inventario;
import Entidad.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

public class ValidarInventario {

    private ManipularConecciones conexion = null;

    public ValidarInventario(ManipularConecciones conexion) {
        this.conexion = conexion;
        inventariosDAO = new InventariosDAO(this.conexion.getConeccion());
    }

    InventariosDAO inventariosDAO;

    public String[][] llenarMatrizInv(int idEspacio, Usuario par) throws SQLException {
        return inventariosDAO.leer(par, idEspacio);

    }

    public boolean ValidarInfoInventario(Usuario par, String id_espacio, ArrayList<Inventario> inv, ArrayList<String> invdelet) {
        boolean b = true;
        if (inv.size() > 0) {
            b = inventariosDAO.actualizar(par, inv, id_espacio);
            if (invdelet.size() > 0 && par.getTipoUsuario() == 2) {
                return inventariosDAO.eliminar(par, invdelet);
            } else {
                return b;
            }
        } else {
            if (invdelet.size() > 0 && par.getTipoUsuario() == 2) {
                return inventariosDAO.eliminar(par, invdelet);
            } else {
                return b;
            }
        }
    }

}
