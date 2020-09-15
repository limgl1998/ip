package duke.Tasks;

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

    @Override
    public String getAdditionalInformation() {
        return by;
    }
}
