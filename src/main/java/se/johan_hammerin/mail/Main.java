package se.johan_hammerin.mail;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Textfält för mottagarens e-postadress
        JTextField textField1 = new JTextField(20);
        // Textfält för ämne
        JTextField textField2 = new JTextField(20);
        // Textfält för innehållet i mejlet
        JTextField textField3 = new JTextField(20);

        // Etikett för mottagarens e-postadress
        JLabel label1 = new JLabel("Skicka till: ");
        // Etikett för ämne
        JLabel label2 = new JLabel("Rubrik ");
        // Etikett för innehållet i mejlet
        JLabel label3 = new JLabel("Innehåll: ");

        // Skapa en instans av JPanel
        JPanel emailPanel = new JPanel();

        // Lägg till första JLabel-instansen till din JPanel
        emailPanel.add(label1);
        emailPanel.add(textField1);
        emailPanel.add(Box.createHorizontalStrut(15)); // Skapa lite avstånd

        emailPanel.add(label2);
        emailPanel.add(textField2);
        emailPanel.add(Box.createHorizontalStrut(15)); // Skapa lite avstånd igen

        emailPanel.add(label3);
        emailPanel.add(textField3);

        // Visa dialogruta
        int result = JOptionPane.showConfirmDialog(null, emailPanel, "Skicka mejl", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION) {
            // Hämta användarens inmatningar från textfälten
            String mailAdress = textField1.getText();
            String subject = textField2.getText();  // Korrigerat, nu hämtar rätt ämnesfält
            String text = textField3.getText();

            // Skriv ut till konsolen
            System.out.println("Skicka mejl till: " + mailAdress + "\nÄmne: "+ subject + "\nText:" + text);

            // Skapa en instans av EmailSenderImpl och skicka e-post
            String username = "johan.hammerin@stud.sti.se";  // Ange din mejladress
            String password = "Jabbaribbo03.";  // Ange ditt lösenord
            EmailSenderImpl emailSender = new EmailSenderImpl(username, password);

            // Skicka mejlet
            emailSender.sendEmail(mailAdress, subject, text);

            // Rensa textfälten efter användning
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");

        } else {
            System.out.println("Email skickades inte");
        }
    }
}
