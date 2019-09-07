import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents information stored as deadline.
 * A Deadline object corresponds to details users require for deadline.
 */
public class Deadline extends Task {
    /** Deadline stated by user */
    protected String by;

    /**
     * Initializes description and deadline of Deadline.
     *
     * @param description Describes the task from user
     * @param by Deadline for user to complete the task by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.display = "D";

        // Parsing string to date
        dateFormat(by);
    }

    /**
     * Initializes completion, description and deadline of Deadline.
     *
     * @param completion States if task has been complete
     * @param description Describes the task from user
     * @param by Deadline for user to complete the task by
     */
    public Deadline(String completion, String description, String by) {
        super(description);
        this.display = "D";

        if (completion.equals(this.completed)) {
            this.setComplete();
        }

        // Parsing string to date
        dateFormat(by);
    }

    /**
     * Returns a formatted string for storage.
     *
     * @return Formatted string for general storage
     */
    @Override
    public String toString() {
        return "[D]["
                + super.getStatusIcon()
                + "] "
                + super.getStatusDescription()
                + " (by: "
                + this.by
                + ")";
    }

    /**
     * Formats Deadline object for writing to file.
     *
     * @return Formatted string to be written to file
     */
    @Override
    public String lineWriter() {
        return "deadline|"
                + super.isDone
                + "|"
                + super.description
                + "|/by|"
                + this.by;
    }

    /**
     * Formats string to a date format.
     *
     * @param inputDate Date as a string
     */
    public void dateFormat(String inputDate) {
        SimpleDateFormat f1 = new SimpleDateFormat("d/MM/yyyy HHmm");
        try {
            Date userDate = f1.parse(inputDate.trim());

            // Interested in this specific date display
            String dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT).format(userDate);

            this.by = dateToStr;

        } catch (ParseException e) {
            // Invalid date formatting: just read as String
            // userDate returns null for unparseable date
            this.by = inputDate;
        }
    }
}