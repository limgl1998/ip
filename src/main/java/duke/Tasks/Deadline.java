package duke.Tasks;

/**
 * Represents a Deadline task
 * It has a description, done status and a deadline by
 */

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns current status, description and deadline (by) of Deadline task
     * @return status, description and by
     */
    @Override
    public String getStatusAndDescription() {
        return "[D]" + super.getStatusAndDescription() + "(by: " + by + ")";
    }

    /**
     * Returns deadline (by)
     * @return by
     */
    @Override
    public String getAdditionalInformation() {
        return by;
    }
}
