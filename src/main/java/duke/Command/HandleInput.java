package duke.Command;

import duke.Tasks.TaskList;

public class HandleInput {

    private static final TaskList list = new TaskList();

    public static void handlesInput(String input) {

        Message.printDashedLine();
        try {
            if (isCommand(input, "list")) {
                list.printTaskList();
            } else if (isCommand(input, "done")) {
                list.markAsDone(input);
            } else if (isCommand(input, "deadline")) {
                list.addDeadline(input);
            } else if (isCommand(input, "event")) {
                list.addEvent(input);
            } else if (isCommand(input, "todo")) {
                list.addTask(input);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e) {
            Message.printInvalidInput();
        }
        Message.printDashedLine();
    }

    private static boolean isCommand(String input, String command) {
        if (input.strip().toLowerCase().contains("list")) {
            return input.strip().equalsIgnoreCase("list");
        } else {
            return input.strip().toLowerCase().startsWith(command);
        }
    }
}

