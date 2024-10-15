package se.johan_hammerin.lektion_4.messenger;

public class Main {
    public static void main(String[] args) {
        //Messenger
        Messenger emailMessenger = new EmailMessenger();

        //MessageService
        MessageService service = new MessageService(emailMessenger);

        //Skicka ett meddelande
        service.send("Mig","HejHej");
    }
}
