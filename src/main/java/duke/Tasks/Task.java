package duke.Tasks;

/**
 * Represents a Task
 * It has a description and done status
 */

public abstract class Task {
    protected String description;
    protected Boolean isDone;

    public Boolean getDone() {
        return isDone;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
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

    public String getAdditionalInformation() {
        return null;
    }
}
