package es.deusto.spq.client;


public class AuthResponse {
    private String token;
    private boolean isAdmin;

    public AuthResponse() {
        // Constructor sin argumentos requerido por Jackson para deserializar el objeto.
    }

    public AuthResponse(String token, boolean isAdmin) {
        this.token = token;
        this.isAdmin = isAdmin;
    }

    //Devuelve el token en forma de String
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}