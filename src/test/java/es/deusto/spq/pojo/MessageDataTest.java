package es.deusto.spq.pojo;

public class MessageDataTest {

    private String message;

    public MessageDataTest() {
        // required by serialization
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}