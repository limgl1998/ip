package duke.Tasks;

public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String getAt() {
        return at;
    }

    @Override
    public String getStatusAndDescription() {
        return "[E]" + super.getStatusAndDescription() + "(at: " + at + ")";
    }

    public String getAdditionalInformation() {
        return at;
    }
}
