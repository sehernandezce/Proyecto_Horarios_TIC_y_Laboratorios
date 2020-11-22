package Entidad;

public class Correo {
    
    private String correoRemitente;
    private String passwordRemitente;
    private String correoReceptor;
    private String asunto;
    private  String mensaje;
    
    
    public String getCorreoRemitente() {
        return correoRemitente;
    }

    public void setCorreoRemitente(String correoRemitente) {
        this.correoRemitente = correoRemitente;
    }

    public String getPasswordRemitente() {
        return passwordRemitente;
    }

    public void setPasswordRemitente(String passwordRemitente) {
        this.passwordRemitente = passwordRemitente;
    }

    public String getCorreoReceptor() {
        return correoReceptor;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
