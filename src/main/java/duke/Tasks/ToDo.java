package duke.Tasks;

/**
 * Represents a todo task
 * It has a description and done status
 */

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getStatusAndDescription() {
        return "[T]" + super.getStatusAndDescription();
    }
}
