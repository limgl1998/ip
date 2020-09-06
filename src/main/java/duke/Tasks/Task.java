package duke.Tasks;

public class Task {
    protected String description;
    protected Boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markTaskAsDone() {
        this.isDone = true;
    }

    private String getStatusIcon() {
        return ("[" + (isDone ? "\u2713" : "\u2718") + "] "); //return tick or X symbols
    }

    public String getStatusAndDescription() {
        return getStatusIcon() + description;
    }
}
