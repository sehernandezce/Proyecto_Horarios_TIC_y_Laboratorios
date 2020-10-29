package Entidad;

public class Espacio {

    private int id_Espacios;
    private int capacidad;   
    private int tipoEspacio;
    private String nombreEspacio;
    private String numEspacio;   
    private int id_edificio;
    private int id_encargado;
    private Boolean activo;

    public int getId_Espacios() {
        return id_Espacios;
    }

    public void setId_Espacios(int id_Espacios) {
        this.id_Espacios = id_Espacios;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(int tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public String getNombreEspacio() {
        return nombreEspacio;
    }

    public void setNombreEspacio(String nombreEspacio) {
        this.nombreEspacio = nombreEspacio;
    }

    public String getNumEspacio() {
        return numEspacio;
    }

    public void setNumEspacio(String numEspacio) {
        this.numEspacio = numEspacio;
    }

    public int getId_edificio() {
        return id_edificio;
    }

    public void setId_edificio(int id_edificio) {
        this.id_edificio = id_edificio;
    }

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    

    
    
    
    
    
    
    
}
