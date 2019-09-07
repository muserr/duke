/**
 * Represents a task from user.
 * A Task object stores information provided by user.
 */
public class Todo extends Task {

    /**
     * Constructor for Todo that initializes task description.
     *
     * @param description Description of task.
     */
    Todo(String description) {
        super(description);
        this.display = "T";
    }

    /**
     * Another constructor for Todo.
     *
     * @param completion Task status
     * @param description Description of task
     */
    Todo(String completion, String description) {
        super(description);
        this.display = "T";

        // Boolean is set as completed if deemed true from text file
        if (completion.equals(this.completed)) {
            this.setComplete();
        }
    }

    /**
     * Method returns a formatted string that can be used for storage.
     *
     * @return Formatted string for storage
     */
    @Override
    public String toString() {
        return "[T][" + super.getStatusIcon() + "] " + super.description;
    }

    /**
     * Formats Todo object for writing to file.
     *
     * @return Formatted string to be written to file
     */
    @Override
    public String lineWriter() {
        return "todo|"
                + super.isDone
                + "|"
                + super.description;
    }
}
