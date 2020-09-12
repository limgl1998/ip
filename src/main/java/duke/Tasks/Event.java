package duke.Tasks;

import duke.Tasks.Task;

public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String getStatusAndDescription() {
        return "[E]" + super.getStatusAndDescription() + "(at: " + at + ")";
    }
}