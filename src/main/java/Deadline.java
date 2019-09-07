import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents information stored as deadline.
 * A Deadline object corresponds to details users require for deadline.
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Constructor for Deadline class that initializes description
     * and deadline of task.
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
     * Another constructor for Deadline.
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
     * Method returns a formatted string that can be used for storage.
     *
     * @return Formatted string for general storage
     */
    @Override
    public String toString() {
        return "[D]["
                + super.getStatusIcon()
                + "] "
                + super.getStatusDescription()
                + " (by: " + this.by + ")";
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
     * Method that obtains date as a string and formats that string
     * to day/mounth/year 24-hour format.
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