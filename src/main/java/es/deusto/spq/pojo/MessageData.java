package es.deusto.spq.pojo;

public class MessageData {
    // ATRIBUTOS
    private String message;
    // CONSTRUCTOR
    public MessageData() {
        // required by serialization
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}