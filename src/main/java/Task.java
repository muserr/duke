/**
 * Represents a task from user.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Default constructor.
     * @param description Description of task provided
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Obtain task status as an icon.
     * @return isDone Icon representation of isDone
     */
    public String getStatusIcon() {
        // Return Y for complete or N for incomplete
        return (isDone ? "Y" : "N");
    }

    /**
     * Modifies status variable.
     * @return description Description of task
     */
    public String getStatusDescription() {
        return this.description;
    }

    /**
     * Assigns a completed status to isDone.
     */
    public void setComplete() {
        this.isDone = true;
    }
}
