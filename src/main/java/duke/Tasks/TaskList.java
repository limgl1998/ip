package duke.Tasks;

import duke.Command.CommandType;
import duke.Command.DukeException;
import duke.GeneralMethods;
import duke.Command.Ui;

import java.util.ArrayList;


public class TaskList {
    private static final int NUMBER_OF_PARTS = 2;
    private final ArrayList<Task> list;
    private final Ui ui = new Ui();

    public TaskList() {
        list = new ArrayList<>();
    }

    public int getNumberOfTasks() {
        return list.size();
    }

    public void printTaskList() {
        if (list.isEmpty()) {
            ui.printEmptyTaskList();
            return;
        }
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + list.get(i).getStatusAndDescription());
        }
    }

    public void markAsDone(String command, boolean printMessage) {
        command = GeneralMethods.removeCommandFromInput(command, CommandType.done);
        //Error handling for input "done" without task number
        if (isTaskListEmptyOrIsCommandTypeInvalid(command)) {
            return;
        }
        int index = Integer.parseInt(command);
        index--;
        //Error handling for invalid task number
        try {
            list.get(index).markTaskAsDone();
            if (printMessage) {
                ui.printTaskIsMarkedAsDone();
                System.out.println("      " + list.get(index).getStatusAndDescription());
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            ui.printInvalidTaskNumber(list.size());
        }
    }

    public void addTask(String description, boolean printMessage) {
        description = GeneralMethods.removeCommandFromInput(description, CommandType.todo);

        try {
            if (description.isEmpty()) {
                throw new DukeException();
            }
            list.add(new ToDo(description));
            if (printMessage) {
                ui.printGotIt();
                printStatusDescriptionAndNumberOfTasks();
            }
        } catch (DukeException e) {
            ui.printEmptyTodoDescription();
        }
    }

    public void addEvent(String description, boolean printMessage) {
        if (!description.contains("/at")) {
            ui.printMissingKeyword("/at");
            return;
        }
        description = GeneralMethods.removeCommandFromInput(description, CommandType.event);
        String[] eventInformation = description.split("/at", NUMBER_OF_PARTS);
        /* eventInformation[0] = description of event
         * eventInformation[1] = event date
         */
        if (doNotHaveDescription(eventInformation)) {
            ui.printEmptyEventDescription();
            return;
        }
        list.add(new Event(eventInformation[0], eventInformation[1].strip()));
        if (printMessage) {
            ui.printGotIt();
            printStatusDescriptionAndNumberOfTasks();
        }
    }

    public void addDeadline(String description, boolean printMessage) {
        if (!description.contains("/by")) {
            ui.printMissingKeyword("/by");
            return;
        }
        description = GeneralMethods.removeCommandFromInput(description, CommandType.deadline);
        String[] deadlineInformation = description.split("/by", NUMBER_OF_PARTS);
        /* deadlineInformation[0] = description of task
         * deadlineInformation[1] = deadline date
         */
        if (doNotHaveDescription(deadlineInformation)) {
            ui.printEmptyDeadlineDescription();
            return;
        }
        list.add(new Deadline(deadlineInformation[0], deadlineInformation[1].strip()));
        if (printMessage) {
            ui.printGotIt();
            printStatusDescriptionAndNumberOfTasks();
        }
    }

    private void printStatusDescriptionAndNumberOfTasks() {
        System.out.println("       " + list.get(list.size() - 1).getStatusAndDescription());
        ui.printNumberOfTasksInList(list.size());
    }

    private boolean doNotHaveDescription(String[] input) {
        return input.length != NUMBER_OF_PARTS;
    }

    public void deleteTask(String command) {
        command = GeneralMethods.removeCommandFromInput(command, CommandType.delete);
        if (isTaskListEmptyOrIsCommandTypeInvalid(command)) {
            return;
        }
        int index = Integer.parseInt(command);
        index--;
        //Error handling for invalid task number
        try {
            if (index >= list.size() || index < 0) {
                throw new DukeException();
            }
            ui.printTaskIsDeleted();
            System.out.println("      " + list.get(index).getStatusAndDescription());
            list.remove(index);
            ui.printNumberOfTasksInList(list.size());
        } catch (DukeException e) {
            ui.printInvalidTaskNumber(list.size());
        }
    }

    private boolean isTaskListEmptyOrIsCommandTypeInvalid(String command) {
        if (list.isEmpty()) {
            ui.printEmptyTaskList();
            return true;
        } else if (command.isEmpty() || !GeneralMethods.isNumeric(command)) {
            ui.printInvalidTaskNumber(list.size());
            return true;
        }
        return false;
    }

    public ArrayList<Task> getList() {
        return list;
    }
}
