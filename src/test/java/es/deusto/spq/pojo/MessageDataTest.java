package es.deusto.spq.pojo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;

public class MessageDataTest {

    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));

    private MessageData messageData;

    @Before
    public void setUp() {
        messageData = new MessageData();
    }

    @Test
   // @JUnitPerfTest(threads = 10, durationMs = 2000)
    public void testGetSetMessage() {
        assertNull(messageData.getMessage());
        String message = "This is a test message.";
        messageData.setMessage(message);
        assertEquals(message, messageData.getMessage());
    }
}
