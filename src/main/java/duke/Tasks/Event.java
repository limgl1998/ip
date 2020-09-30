package duke.Tasks;

/**
 * Represents an Event task
 * It has a description, done status and an event date
 */

public class Event extends Task {
    protected String date;

    public Event(String description, String date) {
        super(description);
        this.date = date;
    }

    /**
     * Returns current status, description and date of Event task
     *
     * @return current status, description and date
     */
    @Override
    public String getStatusAndDescription() {
        return "[E]" + super.getStatusAndDescription() + "(at: " + date + ")";
    }

    /**
     * Returns event date
     *
     * @return date
     */
    public String getAdditionalInformation() {
        return date;
    }
}
