package duke.Tasks;

/**
 * Represents an Event task
 * It has a description, done status and an event location
 */

public class Event extends Task {
    protected String location;

    public Event(String description, String location) {
        super(description);
        this.location = location;
    }

    /**
     * Returns current status, description and event location of Event task
     *
     * @return current status, description and location
     */
    @Override
    public String getStatusAndDescription() {
        return "[E]" + super.getStatusAndDescription() + "(at: " + location + ")";
    }

    /**
     * Returns event location
     *
     * @return location
     */
    public String getAdditionalInformation() {
        return location;
    }
}
