package es.deusto.spq.pojo;

import java.util.List;

public class UserData {
    // Atributos
    private String id;
    private String password;
    private boolean admin;
    // CONSTRUCTOR Para inicializar un usuario con permisos (para crear admin)
    public UserData(String id, String password, boolean admin) {
        this.id = id;
        this.password = password;
        this.admin = admin;
    }
    // CONSTRUCTOR vacio Para inicializar un usuario sin permisos de administrador
    public UserData() {
        this.id = "";
        this.password = "";
        this.admin = false;
    }

    private List<String> messages; // Asume que es una lista de mensajes de texto

    // Agrega los getters y setters correspondientes
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
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