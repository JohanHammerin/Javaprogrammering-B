package se.johan_hammerin.mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSenderImpl implements EmailSender {
    //Constants
    private final String username;
    private final String password;
    private final Properties properties;

    //Constructor
    public EmailSenderImpl(String username, String password) {
        this.username = username;
        this.password = password;
        this.properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", "587");

    }


    //Methods
    //Skicka enkelt mejl
    // Skicka enkelt mejl
    @Override
    public void sendEmail(String to, String subject, String messageText) {
        doSendEmail(to, subject, messageText, null);

    }

    // Skicka mejl med en CC-adress
    @Override
    public void sendEmail(String to, String subject, String messageText, String cc) {
        doSendEmail(to, subject, messageText, cc);

    }

    private void doSendEmail(String to, String subject, String messageText, String cc) {
        //Session som loggar in på mejl-servern
        //För att hitta rätt mejl-server används properties-värdena
        //För att logga in på mejl-servern används username och password, dvs mejladress + lösenord
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            //Skapa ett meddelande
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);

            if(cc != null && !cc.isEmpty()) {
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to));
            }

            //Skicka meddelandet
            Transport.send(message);
            System.out.println("E-post skickad");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
