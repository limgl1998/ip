public class TaskList {
    private static final int NUMBER_OF_PARTS = 2;

    private Task[] list;
    private static int numberOfTasks;

    public TaskList() {
        list = new Task[100];
        numberOfTasks = 0;
    }

    public static int getNumberOfTasks() {
        return numberOfTasks;
    }

    public void printTaskList() {
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("     " + (i+1) + ". " + list[i].getStatusAndDescription());
        }
    }

    public void markAsDone(String command) {
        command = GeneralMethods.removeCommandFromInput(command , CommandType.done);
        //Error handling for input "done" without task number
        if(command.isEmpty()|| !GeneralMethods.isNumeric(command)) {
            Message.printInvalidInput();
            return;
        }
        int index = Integer.parseInt(command);
        index--;
        //Error handling for invalid task number
        if(index >= numberOfTasks || index < 0) {
            Message.printInvalidInput();
        } else {
            list[index].markTaskAsDone();
            System.out.println("     Nice! I've marked this task as done!");
            System.out.println("      " + list[index].getStatusAndDescription());
        }
    }

    public void addTask(String description) {
        Message.printGotIt();
        description = GeneralMethods.removeCommandFromInput(description, CommandType.todo);
        list[numberOfTasks] = new ToDo(description);
        printStatusDescriptionAndNumberOftasks();
    }

    public void addEvent(String description) {
        if (!description.contains("/at")) {
            Message.printInvalidInput();
            return;
        }
        Message.printGotIt();
        description = GeneralMethods.removeCommandFromInput(description, CommandType.event);
        String[] eventInformation = description.split("/at", NUMBER_OF_PARTS);
        /* eventInformation[0] = description of event
         * eventInformation[1] = event date
         */
        list[numberOfTasks] = new Event(eventInformation[0],eventInformation[1].strip());
        printStatusDescriptionAndNumberOftasks();
    }

    public void addDeadline(String description) {
        if (!description.contains("/by")) {
            Message.printInvalidInput();
            return;
        }
        Message.printGotIt();
        description = GeneralMethods.removeCommandFromInput(description, CommandType.deadline);
        String[] deadlineInformation = description.split("/by", NUMBER_OF_PARTS);
        /* deadlineInformation[0] = description of task
         * deadlineInformation[1] = deadline date
         */
        list[numberOfTasks] = new Deadline(deadlineInformation[0],deadlineInformation[1].strip());
        printStatusDescriptionAndNumberOftasks();
    }

    private void printStatusDescriptionAndNumberOftasks() {
        System.out.println("       " + list[numberOfTasks].getStatusAndDescription());
        numberOfTasks++;
        Message.printNumberOfTasksInList(numberOfTasks);
    }
}
