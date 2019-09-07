/**
 * Represents a task from user.
 * A Task object stores information provided by user.
 */
public class Task {
    protected String description;
    protected String display;
    protected boolean isDone;
    protected String completed = "true";

    /**
     * Default constructor for Task.
     *
     * @param description Description of task provided
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Method obtains task status as an icon.
     * Returns 'Y' for complete and 'N' for incomplete.
     *
     * @return isDone Icon representation of isDone
     */
    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    /**
     * Method obtains task abbreviation.
     * Returns displayed letter of the task.
     *
     * @return display Letter representative of task
     */
    public String getDisplayIcon() {
        return this.display;
    }

    /**
     * Method modifies status variable.
     *
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

    /**
     * Method returns an empty string.
     *
     * @return An empty string
     */
    public String lineWriter() {
        return "";
    }

    /**
     * Method searches for a keyword and returns status if keyword
     * is found in description found.
     * Returns true if keyword is found in description is found
     * and returns false if keyword in description is not found.
     *
     * @param keyword Search query from user
     * @return True if keyword is found in description, otherwise return false
     */
    public boolean descriptionSearch(String keyword) {
        return this.description.contains(keyword);
    }
}
