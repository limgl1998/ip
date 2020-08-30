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
        for (int i = 0; i < numberOfTasks; i++) {
            System.out.println("     " + (i+1) + ". " + this.list[i].description);
        }
    }
}
