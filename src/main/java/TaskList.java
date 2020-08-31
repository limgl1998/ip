public class TaskList {
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
        command = removeCommandFromInput(command , "done");
        int index;
        index = Integer.parseInt(command);
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

    private String removeCommandFromInput(String input, String command) {
        int commandLength = command.length();
        input = input.strip();
        input = input.substring(commandLength);
        input = input.strip();
        return input;
    }

    public void addTask(String description) {
        Message.printGotIt();
        description = removeCommandFromInput(description, "todo");
        list[numberOfTasks] = new ToDo(description);
        System.out.println("       " + list[numberOfTasks].getStatusAndDescription());
        numberOfTasks++;
        Message.printNumberOfTasksInList(numberOfTasks);
    }

    public void addEvent(String description) {
        if (!description.contains("/at")) {
            Message.printInvalidInput();
            return;
        }
        Message.printGotIt();
        description = removeCommandFromInput(description, "event");
        String[] eventInformation = description.split("/at", 2);
        /* eventInformation[0] = description of event
         * eventInformation[1] = event date
         */
        list[numberOfTasks] = new Event(eventInformation[0],eventInformation[1].strip());
        System.out.println("       " + list[numberOfTasks].getStatusAndDescription());
        numberOfTasks++;
        Message.printNumberOfTasksInList(numberOfTasks);
    }

    public void addDeadline(String description) {
        if (!description.contains("/by")) {
            Message.printInvalidInput();
            return;
        }
        Message.printGotIt();
        description = removeCommandFromInput(description, "deadline");
        String[] deadlineInformation = description.split("/by", 2);
        /* deadlineInformation[0] = description of task
         * deadlineInformation[1] = deadline date
         */
        list[numberOfTasks] = new Deadline(deadlineInformation[0],deadlineInformation[1].strip());
        System.out.println("       " + list[numberOfTasks].getStatusAndDescription());
        numberOfTasks++;
        Message.printNumberOfTasksInList(numberOfTasks);
    }
}
