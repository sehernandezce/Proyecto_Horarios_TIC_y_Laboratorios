package Control;

import Entidad.Correo;
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
import javax.swing.JOptionPane;



public class EnviarCorreo {
        
    public boolean enviarC(Correo correo) throws AddressException{
            Properties props =new Properties ();
            props.setProperty("mail.smtp.host","smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.port","587");
            props.setProperty("mail.smtp.auth","true");
            
            Session session= Session.getDefaultInstance(props);
            
            String correoRemitente =correo.getCorreoRemitente(); // va el corre;
            String passwordRemitente=correo.getPasswordRemitente();
            String correoReceptor=correo.getCorreoReceptor();
            String asunto=correo.getAsunto();
            String mensaje=correo.getMensaje();//Hola <br>  <b>java></b><br><br>       b en negrita br salto de linea             
            
            MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(correoRemitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
           // message.addRecipient(Message.RecipientType.BCC, new InternetAddress(correoReceptor)); PARA ENVIAR UNA COPIA
           message.setSubject(asunto);
           message.setText(mensaje, "ISO-8859-1","html"); //
          
           /*
           para enviar contenido
           
           */
           Transport t =session.getTransport("smtp");
           t.connect(correoRemitente, passwordRemitente);
           t.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
           t.close();
            return true;        
        } catch (MessagingException ex) {
          
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
            return false;             
        }
         
    }
}
