package es.deusto.spq.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageDataTest {

    private MessageData messageData;

    @Before
    public void setUp() {
        messageData = new MessageData();
    }

    @Test
    public void testGetSetMessage() {
        assertNull(messageData.getMessage());
        String message = "This is a test message.";
        messageData.setMessage(message);
        assertEquals(message, messageData.getMessage());
    }
}
