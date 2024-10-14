package se.johan_hammerin.mail;

public interface EmailSender {
    public void sendEmail(String to, String subject, String messageText, String cc);
    public void sendEmail(String to, String subject, String messageText);
}
