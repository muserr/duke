/**
 * Represents information stored as event.
 * A Event object corresponds to details users require for events.
 */
public class Event extends Task {
    /** Describes location of event */
    protected String at;

    /**
     * Initializes the location of event and description.
     *
     * @param description Describes the task from user
     * @param at Location for event to be held at
     */
    Event(String description, String at) {
        super(description);
        this.at = at;
        this.display = "E";
    }

    /**
     * Initializes the location of event and description using alternative constructor.
     *
     * @param completion States if task have been completed
     * @param description Describes the task from user
     * @param at Location for event to be held at
     */
    Event(String completion, String description, String at) {
        super(description);
        this.at = at;
        this.display = "E";

        if (completion.equals(this.completed)) {
            this.setComplete();
        }
    }

    /**
     * Returns a formatted string that can be used for storage purposes.
     *
     * @return Formatted string for storage
     */
    @Override
    public String toString() {
        return "[E]["
                + super.getStatusIcon()
                + "] "
                + super.description
                + " (at: "
                + this.at
                + ")";
    }

    /**
     * Formats Event object for writing to file.
     *
     * @return Formatted string to be written to file
     */
    @Override
    public String lineWriter() {
        return "event|"
                + super.isDone
                + "|"
                + super.description
                + "|/at|"
                + this.at;
    }
}
