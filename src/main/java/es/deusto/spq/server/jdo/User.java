package es.deusto.spq.server.jdo;

import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

@PersistenceCapable
public class User {
	@PrimaryKey
	String id=null;
	String password=null;
	boolean admin = false;
	
	@Persistent(mappedBy="user", dependentElement="true")
	@Join
	Set<Message> messages = new HashSet<>();
	
	// La propiedad reservas es mapeada por la propiedad cliente en la clase Reserva. La propiedad reservas es una lista de objetos Reserva asociados a un Cliente.
	@Persistent(mappedBy = "cliente")
	private List<Reserva> reservas = new ArrayList<>();
	
	// CONSTRUCTOR Para inicializar un usuario sin permisos de administrador
	public User(String id, String password) {
		this.id = id;
		this.password = password;
		this.admin = false;
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
		for (Message message: this.messages) {
			messagesStr.append(message.toString() + " - ");
		}
        return "User: login --> " + this.id + ", password -->  " + this.password + ", messages --> [" + messagesStr + "]";
    }
}