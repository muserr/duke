public class Todo extends Task{
    /**
     * Identical parameters passed for Task and ToDo
     * @param description Obtain user inputs
     */
    Todo (String description) {
        super(description);
        this.display = "T";
    }

    @Override
    public String toString() {
        return "[T][" + super.getStatusIcon() + "] " + super.description;
    }
}
