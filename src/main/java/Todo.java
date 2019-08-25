public class Todo extends Task{
    /**
     * Identical parameters passed for Task and ToDo
     * @param description Obtain user inputs
     */
    Todo (String description) {
        super(description);
        this.display = "T";
    }

    Todo (String completion, String description) {
        super(description);
        this.display = "T";

        // Boolean is set as completed if deemed true from text file
        if (completion.equals(this.completed)) {
            this.setComplete();
        }
    }

    @Override
    public String toString() {
        return "[T][" + super.getStatusIcon() + "] " + super.description;
    }

    @Override
    public String lineWriter() {
        return "todo|"
                + super.isDone
                + "|"
                + super.description;
    }
}
