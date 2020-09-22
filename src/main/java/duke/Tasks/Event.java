package duke.Tasks;

/**
 * Represents an Event task
 * It has a description, done status and an event at
 */

public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Returns current status, description and event location (at) of Event task
     * @return current status, description and at
     */
    @Override
    public String getStatusAndDescription() {
        return "[E]" + super.getStatusAndDescription() + "(at: " + at + ")";
    }

    /**
     * Returns event location (at)
     * @return at
     */
    public String getAdditionalInformation() {
        return at;
    }
}
