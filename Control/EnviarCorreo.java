package Control;

import DAO.UsuarioDAO;
import Entidad.Correo;
import Entidad.Usuario;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarCorreo {

    private ManipularConecciones conexion = null;

    public void setManipularConexion(ManipularConecciones conexion) {
        this.conexion = conexion;
    }
    

    public boolean enviarC(Correo correo) throws AddressException, Exception {
        try {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        Usuario u = leerCorreoNot();
        if (u == null) {
            return false;
        }
        String correoRemitente = u.getNombreusuarioInstitucional(); // va el corre;
        String passwordRemitente = u.getContrasenia();

        String correoReceptor = correo.getCorreoReceptor();
        String asunto = correo.getAsunto();
        String mensaje = correo.getMensaje();          

        MimeMessage message = new MimeMessage(session);
        
            message.setFrom(new InternetAddress(correoRemitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html"); //

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            return true;
        } catch (Exception ex) {

            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Usuario leerCorreoNot() throws Exception {
        UsuarioDAO dao = new UsuarioDAO(conexion.getConeccion());
        return dao.leerCorreoNotificar();
    }
}
