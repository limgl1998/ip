public class Message {
    public static void start() {
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

    public static void exit() {
        printDashedLine();
        System.out.println("    Bye. Hope to see you again soon!");
        printDashedLine();
    }

    public static void printDashedLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void printGotIt() {
        System.out.println("     Got it. I've added this task:");
    }

    public static void printNumberOfTasksInList(int numberOfTasks) {
        boolean isMoreThanOne = (numberOfTasks > 1);
        System.out.println("     Now you have " + numberOfTasks + " task" + (isMoreThanOne ? "s" : "") + " in the list.");
    }

    public static void printInvalidInput() {
        System.out.println("    Invalid Input. Please try again.");
    }
}
