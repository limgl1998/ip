public class TaskList {
    private Task[] list;
    private static int numberOfTasks;

    public TaskList() {
        this.list = new Task[100];
        this.numberOfTasks = 0;
    }

    public void addTask(String description) {
        this.list[numberOfTasks] = new Task(description);
        this.numberOfTasks++;
        System.out.println("     added: " + description);
    }

    public void printTaskList() {
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("     " + (i+1) + ". [" + this.list[i].getStatusIcon() + "] " + this.list[i].description);
        }
    }

    public void markAsDone(String command) {
        command = command.replace("done", "");
        command = command.strip();
        int index;
        index = Integer.parseInt(command);
        index--;
        //Error handling for invalid task number
        if(index >= numberOfTasks || index < 0) {
            System.out.println("     Invalid task number. Please try again.");
        } else {
            this.list[index].markTaskAsDone();
            System.out.println("     Nice! I've marked this task as done!");
            System.out.println("     " + " [" + this.list[index].getStatusIcon() + "] " + this.list[index].description);
        }
    }

}
