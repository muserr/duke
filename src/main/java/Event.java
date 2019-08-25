public class Event extends Task {
    protected String at;

    Event(String description, String at) {
        super(description);
        this.at = at;
        this.display = "E";
    }

    @Override
    public String toString() {
        return "[E][" + super.getStatusIcon() + "] " + super.description + "(at: " + this.at + ")";
    }
}
