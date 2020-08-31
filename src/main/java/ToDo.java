public class ToDo extends Task{

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String getStatusAndDescription(){
        return "[T]" + super.getStatusAndDescription();
    }
}
