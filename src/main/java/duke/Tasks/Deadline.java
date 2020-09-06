package duke.Tasks;

import duke.Tasks.Task;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getStatusAndDescription() {
        return "[D]" + super.getStatusAndDescription() + "(by: " + by + ")";
    }

}
