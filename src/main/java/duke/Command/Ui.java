package duke.Command;

public class Ui {
    public static final String SAD_SMILEY = "\u2639";

    /**
     * Print start message
     */
    public void printStart() {
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

    /**
     * Print exit message
     */
    public void printExit() {
        System.out.println("    Bye. Hope to see you again soon!");
        printDashedLine();
    }

    public void printDashedLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void printGotIt() {
        System.out.println("     Got it. I've added this task:");
    }

    /**
     * Prints number of tasks in the list
     *
     * @param numberOfTasks number of tasks in the list
     */
    public void printNumberOfTasksInList(int numberOfTasks) {
        boolean isMoreThanOne = (numberOfTasks > 1);
        System.out.println("     Now you have " + numberOfTasks + " task" + (isMoreThanOne ? "s" : "") + " in the list.");
    }

    public void printInvalidInput() {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! I'm sorry, but I don't know what that means");
        printSuggestUsingHelpCommand();
    }

    public void printEmptyTodoDescription() {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! The description of a todo cannot be empty.");
    }

    public void printEmptyEventDescription() {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! The description of an event cannot be empty.");
    }

    public void printEmptyDeadlineDescription() {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! The description of a deadline cannot be empty.");
    }

    /**
     * Tells user the input is invalid and suggests range of valid inputs
     *
     * @param numberOfTasks total number of tasks in the list
     */
    public void printInvalidTaskNumber(int numberOfTasks) {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! Please input a task number between 1 and " + numberOfTasks + ".");
    }

    public void printEmptyTaskList() {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! List is empty");
    }

    public void printMissingKeyword(String keyword) {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! Please include the keyword " + keyword + " .");
    }

    public void printTaskIsDeleted() {
        System.out.println("     Noted. I've removed this task:");
    }

    public void printTaskIsMarkedAsDone() {
        System.out.println("     Nice! I've marked this task as done!");
    }

    public void printEmptyFindDescription() {
        System.out.println("    " + SAD_SMILEY + " OOPS!!! The description of find cannot be empty.");
    }

    public void printFolderNotFound() {
        System.out.println(SAD_SMILEY + " OOPS!!! Folder does not exist. Creating a folder named \"data\" in the same directory...");
    }

    public void printFolderCreationSuccess() {
        System.out.println("Folder is created successfully.");
    }

    public void printFolderCreationFailure() {
        System.out.println(SAD_SMILEY + " OOPS!!! Folder creation failed");
        System.out.println("Please create a folder named \"data\" in the same directory manually.");
    }

    public void printFileNotFound() {
        System.out.println(SAD_SMILEY + " OOPS!!! File does not exist. Creating a text file named \"data\" in the \"data\" folder...");
    }

    public void printFileCreationSuccess() {
        System.out.println("File is created successfully.");
    }

    public void printFileCreationFailure() {
        System.out.println(SAD_SMILEY + " OOPS!!! File creation failed");
        System.out.println("Please create a text file named \"data\" in the \"data\" folder manually.");
    }

    public void printSomethingWentWrong() {
        System.out.println(SAD_SMILEY + " OOPS!!! something went wrong");
    }

    public void printMatchingTasksNotFound() {
        System.out.println(SAD_SMILEY + " OOPS!!! No matching tasks are found");
    }

    public void printMatchingTasksFound() {
        System.out.println("     Here are the matching tasks in your list:");
    }

    public void printHereAreYourTasks() {
        System.out.println("     Here are the tasks in your list:");
    }

    public void printHelp() {
        System.out.println("     Here are the commands available in Duke:");
        System.out.println("     todo    : adds a todo task to the list");
        System.out.println("     eg. todo do homework");
        System.out.println("     event   : adds an event task to the list");
        System.out.println("     eg. event lunch with cousins /at NEX");
        System.out.println("     deadline: adds a deadline task to the list");
        System.out.println("     eg. deadline iP /by wed");
        System.out.println("     done    : marks a task in the list as done");
        System.out.println("     eg. done 1");
        System.out.println("     delete  : deletes a task in the list");
        System.out.println("     eg. delete 3");
        System.out.println("     find    : looks for the keyword in the list");
        System.out.println("     eg. find lunch");
        System.out.println("     list    : lists out all the tasks in the list");
        System.out.println("     eg. list");
        System.out.println("     bye     : exits the program");
        System.out.println("     eg. bye");
    }

    private void printSuggestUsingHelpCommand() {
        System.out.println("      Enter \"help\" to find out more about the commands available");
    }
}
