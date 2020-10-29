package Entidad;

public class Usuario {
    
    private int idUsuario;
    private String nombreusuarioInstitucional;
    private String contrasenia;   
    private int tipoUsuario;
    
    
    public String getNombreusuarioInstitucional() {
        return nombreusuarioInstitucional;
    }

    public void setNombreusuarioInstitucional(String nombreusuarioInstitucional) {
        this.nombreusuarioInstitucional = nombreusuarioInstitucional;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
   

    
    
    
}
