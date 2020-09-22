package duke.Tasks;

/**
 * Represents a todo task
 * It has a description and done status
 */

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns current status and description of task
     *
     * @return status and description
     */
    @Override
    public String getStatusAndDescription() {
        return "[T]" + super.getStatusAndDescription();
    }
}
