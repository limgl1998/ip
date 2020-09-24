package duke.Command;

import duke.FileIO.Storage;
import duke.Tasks.TaskList;

public class Parser {

    private static final String LIST_KEYWORD = "list";
    private final TaskList list;
    private static Ui ui;
    private static Storage storage;

    public Parser(TaskList list) {
        this.list = list;
        ui = new Ui();
        storage = new Storage();
        storage.readFromFile(list.getList());
    }

    /**
     * Takes in the user's input and carry out the instructions if possible
     * Returns if user input is bye
     * list data is updated upon exit
     *
     * @param input user input
     * @return whether input is BYE
     */
    public boolean handlesInput(String input) {

        ui.printDashedLine();

        try {
            if (isCommand(input, CommandType.LIST)) {
                list.printTaskList();
            } else if (isCommand(input, CommandType.DONE)) {
                list.markAsDone(input);
                storage.writeToFile(list);
            } else if (isCommand(input, CommandType.DEADLINE)) {
                list.addDeadline(input);
                storage.writeToFile(list);
            } else if (isCommand(input, CommandType.EVENT)) {
                list.addEvent(input);
                storage.writeToFile(list);
            } else if (isCommand(input, CommandType.TODO)) {
                list.addTask(input);
                storage.writeToFile(list);
            } else if (isCommand(input, CommandType.DELETE)) {
                list.deleteTask(input);
                storage.writeToFile(list);
            } else if (isCommand(input, CommandType.FIND)) {
                list.find(input);
            } else if (isCommand(input, CommandType.HELP)) {
                ui.printHelp();
            } else if (isCommand(input, CommandType.BYE)) {
                storage.writeToFile(list);
                return true;
            } else {
                throw new DukeException();
            }
        } catch (DukeException e) {
            ui.printInvalidInput();
        }

        ui.printDashedLine();

        return false;
    }

    /**
     * Takes in the user's input and compares with a set of given commands
     *
     * @param input user inputs
     * @param type  one of the defined commands
     * @return whether input contains one of specified command
     */
    private boolean isCommand(String input, CommandType type) {
        String command = type.toString().toLowerCase();
        input = input.strip().toLowerCase();
        if (input.contains(LIST_KEYWORD)) {
            return input.equalsIgnoreCase(LIST_KEYWORD);
        } else {
            return input.startsWith(command);
        }
    }
}

