package es.deusto.spq.pojo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;
import org.junit.Rule;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

public class DirectMessageTest {

	@Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

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
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
	public void testSetAndGetUserData() {
		directMessage.setUserData(userData);
		assertNotNull(directMessage.getUserData());
	}

	@Test
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
	public void testSetAndGetMessageData() {
		directMessage.setMessageData(messageData);
		assertNotNull(directMessage.getMessageData());
	}

	@Test
	@JUnitPerfTest(threads = 10, durationMs = 2000)
	public void testConstructor() {
		DirectMessage directMessage = new DirectMessage();
		assertNotNull(directMessage);
	}

	@Test
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
	public void testGetAndSetUserData() {
		UserData userData = new UserData();
		userData.setId("user");
		directMessage.setUserData(userData);
		assertEquals(userData, directMessage.getUserData());
	}

	@Test
	//@JUnitPerfTest(threads = 10, durationMs = 2000)
	public void testGetAndSetMessageData() {
		MessageData messageData = new MessageData();
		messageData.setMessage("Hello World!");
		directMessage.setMessageData(messageData);
		assertEquals(messageData, directMessage.getMessageData());
	}




}