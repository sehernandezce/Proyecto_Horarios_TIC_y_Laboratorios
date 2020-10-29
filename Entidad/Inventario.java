
package Entidad;


public class Inventario {
    
    private int id_inventario;
    private int id_Espacio;
    private String nombreAtributo;
    private String descripcion;

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_Espacio() {
        return id_Espacio;
    }

    public void setId_Espacio(int id_Espacio) {
        this.id_Espacio = id_Espacio;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
