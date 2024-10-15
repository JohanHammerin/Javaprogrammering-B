package se.johan_hammerin.lektion_4.messenger;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MessageServiceTest extends TestCase {

    public void testSend() {
        // Arrange: skapa en mock Messenger och en MessageService-instans
        MockMessenger mockMessenger = new MockMessenger();
        MessageService messageService = new MessageService(mockMessenger);


        String testRecipient = "test@example.com";
        String testMessage = "Hello, this is a test!";

        // Act: anropa send-metoden på MessageService
        messageService.send(testRecipient, testMessage);


        // Assert: verifiera att rätt data skickades till mock-messenger
        Assert.assertEquals(testRecipient, mockMessenger.getLastRecipient());
        Assert.assertEquals(testMessage, mockMessenger.getLastMessage());
    }
}
