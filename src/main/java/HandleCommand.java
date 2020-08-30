public class HandleCommand {

    protected static TaskList list = new TaskList();

    public static void handlesCommand(String command){

        Message.printDashedLine();
        if (command.equalsIgnoreCase("list")) {
            list.printTaskList();
        } else if (command.toLowerCase().contains("done")) {
            list.markAsDone(command);
        } else {
            list.addTask(command);
        }
        Message.printDashedLine();
    }


}

