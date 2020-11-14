
package Entidad;

public class Solicitud {
    
   private int idSolicitud;
   private String fechaSolicitud;
   private String Observaciones;
   private String estadoSolicitud;
   private String fechaModificacion;
   private String espacioidEspacio;
   private Evento evento;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Solicitud(int idSolicitud, String fechaSolicitud, String Observaciones, String estadoSolicitud, String fechaModificacion, String espacioidEspacio, Evento evento) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.Observaciones = Observaciones;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaModificacion = fechaModificacion;
        this.espacioidEspacio = espacioidEspacio;
        this.evento = evento;
    }
    
    

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEspacioidEspacio() {
        return espacioidEspacio;
    }

    public void setEspacioidEspacio(String espacioidEspacio) {
        this.espacioidEspacio = espacioidEspacio;
    }
    
    
    
    
    
}
