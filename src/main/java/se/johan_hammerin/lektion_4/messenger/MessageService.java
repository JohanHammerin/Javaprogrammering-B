package se.johan_hammerin.lektion_4.messenger;

public class MessageService {
    //Attribut
    private Messenger messenger;

    //Constructor
    public MessageService(Messenger messenger) {
        setMessenger(messenger);
    }

    //Method
    public void send(String recipient, String message) {
        messenger.sendMessage(recipient, message);
    }

    //Getter & Setter
    public Messenger getMessenger() {
        return this.messenger;
    }

    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }
}
