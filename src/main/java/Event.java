public class Event extends Task {
    protected String at;

    Event(String description, String at) {
        super(description);
        this.at = at;
        this.display = "E";
    }

    Event(String completion, String description, String at) {
        super(description);
        this.at = at;
        this.display = "E";

        if (completion.equals(this.completed)) {
            this.setComplete();
        }
    }

    @Override
    public String toString() {
        return "[E][" + super.getStatusIcon() + "] " + super.description + " (at: " + this.at + ")";
    }

    @Override
    public String lineWriter() {
        return "event|" + super.isDone + "|" + super.description + "|/at|" + this.at;
    }
}
