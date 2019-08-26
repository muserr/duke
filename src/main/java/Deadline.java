import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.display = "D";

        // Parsing string to date
        dateFormat(by);
    }

    public Deadline(String completion, String description, String by) {
        super(description);
        this.display = "D";

        if (completion.equals(this.completed)) {
            this.setComplete();
        }

        // Parsing string to date
        dateFormat(by);
    }

    @Override
    public String toString() {
        return "[D]["
                + super.getStatusIcon()
                + "] "
                + super.getStatusDescription()
                + " (by: " + this.by + ")";
    }

    @Override
    public String lineWriter() {
        return "deadline|"
                + super.isDone
                + "|"
                + super.description
                + "|/by|"
                + this.by;
    }

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