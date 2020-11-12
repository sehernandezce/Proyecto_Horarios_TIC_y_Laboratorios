/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class Solicitud {
    int idSolicitud;
    String fechaSolicitud;
    String Observaciones;
    int estadoSolicitud;
    String fechaModificacion;
    int espacioidEspacio;
    Evento evento;

    public Solicitud(int idSolicitud, String fechaSolicitud, String Observaciones, int estadoSolicitud, String fechaModificacion, int espacioidEspacio, Evento evento) {
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

    public int getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(int estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getEspacioidEspacio() {
        return espacioidEspacio;
    }

    public void setEspacioidEspacio(int espacioidEspacio) {
        this.espacioidEspacio = espacioidEspacio;
    }
    
    
    
    
    
}
