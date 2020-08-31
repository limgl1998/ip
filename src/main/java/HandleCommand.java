public class HandleCommand {

    protected static TaskList list = new TaskList();

    public static void handlesCommand(String command){

        Message.printDashedLine();
        if (command.equalsIgnoreCase("list")) {
            list.printTaskList();
        } else if (command.toLowerCase().contains("done")) {
            list.markAsDone(command);
        } else if (command.toLowerCase().contains("deadline")) {
            list.addDeadline(command);
        } else if (command.toLowerCase().contains("event")) {
            list.addEvent(command);
        }  else if (command.toLowerCase().contains("todo")){
            list.addTask(command);
        } else {
            Message.printInvalidInput();
        }
        Message.printDashedLine();
    }


}

