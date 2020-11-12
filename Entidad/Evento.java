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
public class Evento {
    int idEvento;
    String horaInicio;
    String repeticion;
    String fechaEvento;
    String horaFinalEvento;
    String motivoEvento;
    int idEdificio;
    int tipoRepetición;
    int motivoRepetición;

    public Evento(int idEvento, String horaInicio, String repeticion, String fechaEvento, String horaFinalEvento, String motivoEvento, int idEdificio, int tipoRepetición, int motivoRepetición) {
        this.idEvento = idEvento;
        this.horaInicio = horaInicio;
        this.repeticion = repeticion;
        this.fechaEvento = fechaEvento;
        this.horaFinalEvento = horaFinalEvento;
        this.motivoEvento = motivoEvento;
        this.idEdificio = idEdificio;
        this.tipoRepetición = tipoRepetición;
        this.motivoRepetición = motivoRepetición;
    }
    
    
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getHoraFinalEvento() {
        return horaFinalEvento;
    }

    public void setHoraFinalEvento(String horaFinalEvento) {
        this.horaFinalEvento = horaFinalEvento;
    }

    public String getMotivoEvento() {
        return motivoEvento;
    }

    public void setMotivoEvento(String motivoEvento) {
        this.motivoEvento = motivoEvento;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public int getTipoRepetición() {
        return tipoRepetición;
    }

    public void setTipoRepetición(int tipoRepetición) {
        this.tipoRepetición = tipoRepetición;
    }

    public int getMotivoRepetición() {
        return motivoRepetición;
    }

    public void setMotivoRepetición(int motivoRepetición) {
        this.motivoRepetición = motivoRepetición;
    }
    
    
    
}
