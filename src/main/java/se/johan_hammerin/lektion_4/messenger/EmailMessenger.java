package se.johan_hammerin.lektion_4.messenger;

public class EmailMessenger implements Messenger {

    //Methods
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending mail to " + recipient + ": " + message);
    }
}
