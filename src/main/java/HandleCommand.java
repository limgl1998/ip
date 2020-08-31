public class HandleCommand {

    protected static TaskList list = new TaskList();

    public static void handlesCommand(String command){

        Message.printDashedLine();
        if (command.strip().equalsIgnoreCase("list")) {
            list.printTaskList();
        } else if (command.strip().toLowerCase().startsWith("done")) {
            list.markAsDone(command);
        } else if (command.strip().toLowerCase().startsWith("deadline")) {
            list.addDeadline(command);
        } else if (command.strip().toLowerCase().startsWith("event")) {
            list.addEvent(command);
        }  else if (command.strip().toLowerCase().startsWith("todo")){
            list.addTask(command);
        } else {
            Message.printInvalidInput();
        }
        Message.printDashedLine();
    }


}

