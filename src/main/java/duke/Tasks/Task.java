package duke.Tasks;

/**
 * Represents a Task
 * It has a description and done status
 */

public abstract class Task {
    protected static final String TICK_ICON = "\u2713";
    protected static final String CROSS_ICON = "\u2718";
    protected String description;
    protected Boolean isDone;

    public Boolean getDone() {
        return isDone;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns description of task
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void markTaskAsDone() {
        this.isDone = true;
    }

    private String getStatusIcon() {
        return ("[" + (isDone ? TICK_ICON : CROSS_ICON) + "] ");
    }

    /**
     * Returns current status icon and description of task
     * Tick for done and cross for not done
     * @return status icon and description
     */
    public String getStatusAndDescription() {
        return getStatusIcon() + description;
    }

    /**
     * Returns any other relevant information
     * @return empty string by default
     */
    public String getAdditionalInformation() {
        return "";
    }
}
