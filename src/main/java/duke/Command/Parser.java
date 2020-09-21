package duke.Command;

import duke.FileIO.Storage;
import duke.Tasks.TaskList;

public class Parser {

    private static final TaskList list = new TaskList();
    private static final Ui ui = new Ui();
    private static final Storage storage = new Storage();

    /**
     * Takes in the user's input and carry out the instructions if possible
     *
     * @param input
     * @param printMessage
     * @return
     */
    public static boolean handlesInput(String input, boolean printMessage) {

        if (printMessage) {
            ui.printDashedLine();
        }
        try {
            if (isCommand(input, "list")) {
                list.printTaskList();
            } else if (isCommand(input, "done")) {
                list.markAsDone(input, printMessage);
            } else if (isCommand(input, "deadline")) {
                list.addDeadline(input, printMessage);
            } else if (isCommand(input, "event")) {
                list.addEvent(input, printMessage);
            } else if (isCommand(input, "todo")) {
                list.addTask(input, printMessage);
            } else if (isCommand(input, "delete")) {
                list.deleteTask(input);
            } else if (isCommand(input, "bye")) {
                storage.writeToFile(list);
                return true;
            } else {
                throw new DukeException();
            }
        } catch (DukeException e) {
            ui.printInvalidInput();
        }
        if (printMessage) {
            ui.printDashedLine();
        }
        return false;
    }

    /**
     * Takes in the user's input and compares with a set of given commands
     *
     * @param input
     * @param command
     * @return true if input contains one of specified command else false
     */
    private static boolean isCommand(String input, String command) {
        if (input.strip().toLowerCase().contains("list")) {
            return input.strip().equalsIgnoreCase("list");
        } else {
            return input.strip().toLowerCase().startsWith(command);
        }
    }
}

