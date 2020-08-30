public class TaskList {
    private Task[] list;
    private static int numberOfTasks;

    public TaskList() {
        list = new Task[100];
        numberOfTasks = 0;
    }

    public void addTask(String description) {
        list[numberOfTasks] = new Task(description);
        numberOfTasks++;
        System.out.println("     added: " + description);
    }

    public void printTaskList() {
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("     " + (i+1) + "." + list[i].getStatusIcon() + list[i].description);
        }
    }

    public void markAsDone(String command) {
        command = command.toLowerCase().replace("done", "");
        command = command.strip();
        int index;
        index = Integer.parseInt(command);
        index--;
        //Error handling for invalid task number
        if(index >= numberOfTasks || index < 0) {
            System.out.println("     Invalid task number. Please try again.");
        } else {
            list[index].markTaskAsDone();
            System.out.println("     Nice! I've marked this task as done!");
            System.out.println("     " + list[index].getStatusIcon() + list[index].description);
        }
    }

}
