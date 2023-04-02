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
	
	@Persistent(mappedBy="user", dependentElement="true")
	@Join
	Set<Message> messages = new HashSet<>();
	
	// La propiedad reservas es mapeada por la propiedad cliente en la clase Reserva. La propiedad reservas es una lista de objetos Reserva asociados a un Cliente.
	@Persistent(mappedBy = "user")
	private List<Reserva> reservas = new ArrayList<>();
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}

	public void removeMessage(Message message) {
		messages.remove(message);
	}

	public String getLogin() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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