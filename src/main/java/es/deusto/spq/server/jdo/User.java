package es.deusto.spq.server.jdo;

import javax.jdo.annotations.*;
import java.util.*;
@PersistenceCapable
public class User {
	@PrimaryKey
	String id=null; //nombre 
	String password=null;
	boolean admin = false;
	// La propiedad reservas es mapeada por la propiedad cliente en la clase Reserva. La propiedad reservas es una lista de objetos Reserva asociados a un Cliente.
	@Persistent(mappedBy = "user") // Es mappedBy user ya que la clase se llama  así 
	private List<Reserva> reservas = new ArrayList<>();
	
	
	Set<Message> messages = new HashSet<>();
	
	// CONSTRUCTOR Para inicializar un usuario sin permisos de administrador
	public User(String id, String password) {
		this.id = id;
		this.password = password;
		this.admin = false;
	}

	public User(){

	}
	// CONSTRUCTOR Para inicializar un usuario con permisos (para crear admin)
	public User(String id, String password, boolean admin) {
		this.id = id;
		this.password = password;
		this.admin = admin;
	}
	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(Message message) {
		messages.remove(message);
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
	
	 public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Set<Message> getMessages() {return this.messages;}
	 
	 public String toString() {
		StringBuilder messagesStr = new StringBuilder();
		for (Message message: this.messages) 
			messagesStr.append(message.toString());
        return "User: login --> " + this.id + ", password -->  " + this.password + ", messages --> [" + messagesStr + "]";
    }
}