public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.display = "D";
    }

    public Deadline(String completion, String description, String by) {
        super(description);
        this.by = by;
        this.display = "D";

        if (completion.equals(this.completed)) {
            this.setComplete();
        }
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
}