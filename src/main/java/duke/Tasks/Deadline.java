package duke.Tasks;

/**
 * Represents a Deadline task
 * It has a description, done status and a deadline when it is due
 */

public class Deadline extends Task {
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    /**
     * Returns current status, description and deadline of Deadline task
     *
     * @return status, description and deadline
     */
    @Override
    public String getStatusAndDescription() {
        return "[D]" + super.getStatusAndDescription() + "(by: " + deadline + ")";
    }

    /**
     * Returns deadline (by)
     *
     * @return deadline
     */
    @Override
    public String getAdditionalInformation() {
        return deadline;
    }
}
