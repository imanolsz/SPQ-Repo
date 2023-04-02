package es.deusto.spq.pojo;

public class UserData {

    private String id;
    private String password;
    private boolean admin;

    public UserData() {
        // required by serialization
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "[id=" + id + ", password=" + password + "]";
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}