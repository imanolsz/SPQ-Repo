package es.deusto.spq.pojo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

public class DirectMessageTest {

	private DirectMessage directMessage;
	private UserData userData;
	private MessageData messageData;

    @Before
	public void setUp() throws Exception {
		// Code executed before each test
		directMessage = new DirectMessage();
		userData = new UserData();
		messageData = new MessageData();
		

	}

	@Test
	public void testSetAndGetUserData() {
		directMessage.setUserData(userData);
		assertNotNull(directMessage.getUserData());
	}

	@Test
	public void testSetAndGetMessageData() {
		directMessage.setMessageData(messageData);
		assertNotNull(directMessage.getMessageData());
	}

	@Test
	public void testConstructor() {
		DirectMessage directMessage = new DirectMessage();
		assertNotNull(directMessage);
	}

	@Test
	public void testGetAndSetUserData() {
		UserData userData = new UserData();
		userData.setId("user");
		directMessage.setUserData(userData);
		assertEquals(userData, directMessage.getUserData());
	}

	@Test
	public void testGetAndSetMessageData() {
		MessageData messageData = new MessageData();
		messageData.setMessage("Hello World!");
		directMessage.setMessageData(messageData);
		assertEquals(messageData, directMessage.getMessageData());
	}




}