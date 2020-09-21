package duke.Command;

public class Ui {
    public void start() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printDashedLine();
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        printDashedLine();
    }

    public void exit() {
        System.out.println("    Bye. Hope to see you again soon!");
        printDashedLine();
    }

    public void printDashedLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void printGotIt() {
        System.out.println("     Got it. I've added this task:");
    }

    public void printNumberOfTasksInList(int numberOfTasks) {
        boolean isMoreThanOne = (numberOfTasks > 1);
        System.out.println("     Now you have " + numberOfTasks + " task" + (isMoreThanOne ? "s" : "") + " in the list.");
    }

    public void printInvalidInput() {
        System.out.println("    \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public void printEmptyTodoDescription() {
        System.out.println("    \u2639 OOPS!!! The description of a todo cannot be empty.");
    }

    public void printEmptyEventDescription() {
        System.out.println("    \u2639 OOPS!!! The description of an event cannot be empty.");
    }

    public void printEmptyDeadlineDescription() {
        System.out.println("    \u2639 OOPS!!! The description of a deadline cannot be empty.");
    }

    public void printInvalidTaskNumber(int numberOfTasks) {
        System.out.println("    \u2639 OOPS!!! Please input a task number between 1 and " + numberOfTasks + ".");
    }

    public void printEmptyTaskList() {
        System.out.println("    \u2639 OOPS!!! List is empty");
    }

    public void printMissingKeyword(String keyword) {
        System.out.println("    \u2639 OOPS!!! Please include the keyword " + keyword + " .");
    }

    public void printTaskIsDeleted() {
        System.out.println("     Noted. I've removed this task:");
    }

    public void printTaskIsMarkedAsDone() {
        System.out.println("     Nice! I've marked this task as done!");
    }
}
