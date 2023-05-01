package es.deusto.spq.server.jdo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;
	private String id = "test_user";
	private String password = "test_password";
	private boolean admin = false;

	@Before
	public void setUp() throws Exception {
		user = new User(id, password, admin);
	}

	@After
	public void tearDown() throws Exception {
		user = null;
	}

	@Test
	public void testUser() {
		assertNotNull(user);
		assertEquals(id, user.getId());
		assertEquals(password, user.getPassword());
		assertEquals(admin, user.isAdmin());
	}

	@Test
	public void testAddRemoveMessage() {
		Message message1 = new Message("test_subject1");
		Message message2 = new Message("test_subject2");

		user.addMessage(message1);
		user.addMessage(message2);

		Set<Message> expectedMessages = new HashSet<>();
		expectedMessages.add(message1);
		expectedMessages.add(message2);

		assertEquals(expectedMessages, user.getMessages());

		user.removeMessage(message1);

		Set<Message> expectedMessagesAfterRemove = new HashSet<>();
		expectedMessagesAfterRemove.add(message2);

		assertEquals(expectedMessagesAfterRemove, user.getMessages());
	}

	@Test
	public void testToString() {
		Message message1 = new Message("test_subject1");
		Message message2 = new Message("test_subject2");

		user.addMessage(message1);
		user.addMessage(message2);

		String expectedString = "User: login --> " + id + ", password -->  " + password + ", messages --> [" + message1.toString() + " - " + message2.toString() + "]";

		assertEquals(expectedString, user.toString());
	}
}
