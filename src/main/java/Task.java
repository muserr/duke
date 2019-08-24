public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        // return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        return (isDone ? "Y" : "N"); //return Y for complete or X for incomplete
    }

    public String getStatusDescription() {
        return this.description;
    }

    public void setComplete() {
        this.isDone = true;
    }

}
