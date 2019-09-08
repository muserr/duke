import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the Event class.
 */
public class EventTest {
    @Test
    public void testToString() {
        String description = "Project meeting";
        String location = "COM1";
        Event event = new Event(description, location);

        assertEquals("[E]["
                        + event.getStatusIcon()
                        + "] "
                        + description
                        + " (at: "
                        + location
                        + ")",
                event.toString());
    }

    @Test
    public void testLineWriter() {
        String description = "Project meeting";
        String location = "COM1";

        Event event = new Event(description, location);

        assertEquals("event|"
                        + "false"
                        + "|"
                        + "Project meeting"
                        + "|/at|"
                        + "COM1",
                event.lineWriter()
        );
    }
}
