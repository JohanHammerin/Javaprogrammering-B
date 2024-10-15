package se.johan_hammerin.lektion_4.messenger;

class MockMessenger implements Messenger {
    private String lastRecipient;
    private String lastMessage;

    @Override
    public void sendMessage(String recipient, String message) {
        this.lastRecipient = recipient;
        this.lastMessage = message;
        System.out.println("MockMessenger - sendMessage called with recipient: " + recipient + ", message: " + message); // Debug utskrift
    }

    public String getLastRecipient() {
        return lastRecipient;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
