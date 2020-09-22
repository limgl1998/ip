package duke.Tasks;

import duke.Command.CommandType;
import duke.Command.DukeException;
import duke.GeneralMethods;
import duke.Command.Ui;

import java.util.ArrayList;

/**
 * Task list holds the main arraylist (list) that contains all the information stored
 * All the functions to modify the list are found here
 */

public class TaskList {
    private static final int NUMBER_OF_PARTS = 2;
    private static final String EVENT_KEYWORD = "/at";
    private static final String DEADLINE_KEYWORD = "/by";
    private final ArrayList<Task> list;
    private final Ui ui;

    public TaskList() {
        list = new ArrayList<>();
        ui = new Ui();
    }

    public int getNumberOfTasks() {
        return list.size();
    }

    /**
     * Prints the contents of the list - task, done status and description
     */
    public void printTaskList() {
        if (list.isEmpty()) {
            ui.printEmptyTaskList();
            return;
        }
        ui.printHereAreYourTasks();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("     " + (i + 1) + ". " + list.get(i).getStatusAndDescription());
        }
    }

    /**
     * Changes the status of the task to done
     * Prints a done message when it takes in user input
     *
     * @param command user input
     */
    public void markAsDone(String command) {
        command = GeneralMethods.removeCommandFromInput(command, CommandType.DONE);
        //Error handling for input "done" without task number
        if (isTaskListEmptyOrIsCommandTypeInvalid(command)) {
            return;
        }
        int index = Integer.parseInt(command);
        index--;
        //Error handling for invalid task number
        try {
            list.get(index).markTaskAsDone();
            ui.printTaskIsMarkedAsDone();
            System.out.println("      " + list.get(index).getStatusAndDescription());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            ui.printInvalidTaskNumber(list.size());
        }
    }

    /**
     * Adds a task to the list
     * Prints a done message when it takes in user input
     *
     * @param description user input
     */

    public void addTask(String description) {
        description = GeneralMethods.removeCommandFromInput(description, CommandType.TODO);

        try {
            if (description.isEmpty()) {
                throw new DukeException();
            }
            list.add(new ToDo(description));
            ui.printGotIt();
            printStatusDescriptionAndNumberOfTasks();
        } catch (DukeException e) {
            ui.printEmptyTodoDescription();
        }
    }

    /**
     * Adds an Event to the list
     * Prints a done message when it takes in user input
     *
     * @param description user input
     */
    public void addEvent(String description) {
        if (!description.contains(EVENT_KEYWORD)) {
            ui.printMissingKeyword(EVENT_KEYWORD);
            return;
        }
        description = GeneralMethods.removeCommandFromInput(description, CommandType.EVENT);
        String[] eventInformation = description.split(EVENT_KEYWORD, NUMBER_OF_PARTS);
        /* eventInformation[0] = description of event
         * eventInformation[1] = event date
         */
        if (doesNotHaveDescription(eventInformation)) {
            ui.printEmptyEventDescription();
            return;
        }
        list.add(new Event(eventInformation[0], eventInformation[1].strip()));
        ui.printGotIt();
        printStatusDescriptionAndNumberOfTasks();
    }

    /**
     * Adds a Deadline to the list
     * Prints a done message when it takes in user input
     *
     * @param description user input
     */
    public void addDeadline(String description) {
        if (!description.contains(DEADLINE_KEYWORD)) {
            ui.printMissingKeyword(DEADLINE_KEYWORD);
            return;
        }
        description = GeneralMethods.removeCommandFromInput(description, CommandType.DEADLINE);
        String[] deadlineInformation = description.split(DEADLINE_KEYWORD, NUMBER_OF_PARTS);
        /* deadlineInformation[0] = description of task
         * deadlineInformation[1] = deadline date
         */
        if (doesNotHaveDescription(deadlineInformation)) {
            ui.printEmptyDeadlineDescription();
            return;
        }
        list.add(new Deadline(deadlineInformation[0], deadlineInformation[1].strip()));
        ui.printGotIt();
        printStatusDescriptionAndNumberOfTasks();
    }

    /**
     * Prints the number of tasks in the list
     * Also prints the description of tasks in list
     */
    private void printStatusDescriptionAndNumberOfTasks() {
        System.out.println("       " + list.get(list.size() - 1).getStatusAndDescription());
        ui.printNumberOfTasksInList(list.size());
    }

    private boolean doesNotHaveDescription(String[] input) {
        return input.length != NUMBER_OF_PARTS;
    }

    /**
     * Deletes a task from the list
     *
     * @param command user input
     */
    public void deleteTask(String command) {
        command = GeneralMethods.removeCommandFromInput(command, CommandType.DELETE);
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

    /**
     * Looks for the given command in the descriptions and additional information of tasks in list
     * Prints out the description and additional information if found
     *
     * @param command user input
     */

    public void find(String command) {
        command = GeneralMethods.removeCommandFromInput(command, CommandType.FIND).toLowerCase();
        int i = 0;
        if (list.isEmpty()) {
            ui.printEmptyTaskList();
            return;
        } else if (command.isEmpty()) {
            ui.printEmptyFindDescription();
            return;
        }
        for (Task t : list) {
            if (t.description.toLowerCase().contains(command)
                    || t.getAdditionalInformation().toLowerCase().contains(command)) {
                if (i == 0) {
                    ui.printMatchingTasksFound();
                }
                System.out.println("     " + (i + 1) + ". " + t.getStatusAndDescription());
                i++;
            }
        }
        if (i == 0) {
            ui.printMatchingTasksNotFound();
        }
    }
}
