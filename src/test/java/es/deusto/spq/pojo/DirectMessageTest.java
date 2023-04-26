package es.deusto.spq.pojo;

public class DirectMessageTest {

    private UserData userData;
    private MessageData messageData;

    public DirectMessageTest() {
        // required by serialization
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public void setMessageData(MessageData messageData) {
        this.messageData = messageData;
    }

    public MessageData getMessageData() {
        return this.messageData;
    }
}