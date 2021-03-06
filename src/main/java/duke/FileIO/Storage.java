package duke.FileIO;

import duke.Command.CommandType;
import duke.Command.Ui;
import duke.GeneralMethods;
import duke.Tasks.Deadline;
import duke.Tasks.Event;
import duke.Tasks.Task;
import duke.Tasks.TaskList;
import duke.Tasks.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Allows the user to read or write data to a local file
 */

public class Storage {
    private static final String TICK_ICON = "\u2713";
    private static final int INDEX_OF_TASK_TYPE = 1;
    private static final int NUMBER_OF_PARTS = 2;
    private static final String EVENT_KEYWORD = "/at";
    private static final String DEADLINE_KEYWORD = "/by";
    private static final int LENGTH_OFFSET_FOR_STATUS_ICON = 4;
    public static final String FILE_PATH = "data/data.txt";
    public static final String FOLDER_PATH = "data";
    private final Ui ui = new Ui();

    /**
     * Loads data from save file
     */
    public void readFromFile(ArrayList<Task> list) {
        if (doesFileNotExist()) {
            return;
        }
        File data = new File(FILE_PATH);
        try {
            int index = 0;
            Scanner s = new Scanner(data);
            while (s.hasNext()) {
                transferDataInToList(list, index, s.nextLine());
                index++;
            }
        } catch (FileNotFoundException e) {
            ui.printSomethingWentWrong();
        }
    }

    /**
     * Checks if there the "data" file and "data" folder exists in the specified path
     * If either does not exist, program will create a the missing objects respectively
     * Returns true if file / folder does not exist and cannot be created
     *
     * @return whether file exist or not
     */
    private boolean doesFileNotExist() {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            ui.printFolderNotFound();
            boolean isFolderCreatedSuccessfully = folder.mkdir();
            if (isFolderCreatedSuccessfully) {
                ui.printFolderCreationSuccess();
            } else {
                ui.printFolderCreationFailure();
                return true;
            }
        }
        File data = new File(FILE_PATH);
        if (!data.exists()) {
            ui.printFileNotFound();
            try {
                // to create a file in case it does not exist
                FileWriter fw = new FileWriter(data.getAbsolutePath());
                if (data.exists()) {
                    ui.printFileCreationSuccess();
                } else {
                    ui.printFileCreationFailure();
                }
            } catch (IOException e) {
                return true;
            }
        }
        return false;
    }

    /**
     * Writes data from the task list into the save file
     *
     * @param taskList list where data is stored
     */

    public void writeToFile(TaskList taskList) {
        if (doesFileNotExist()) {
            return;
        }
        File data = new File(FILE_PATH);
        try {
            FileWriter fw = new FileWriter(data.getAbsolutePath());
            ArrayList<Task> list = taskList.getList();
            for (int i = 0; i < taskList.getNumberOfTasks(); i++) {
                String input = formatListDataIntoStorageForm(list, i);
                fw.write(input + "\n");
            }
            fw.close();
        } catch (IOException e) {
            ui.printSomethingWentWrong();
        }
    }

    /**
     * Returns the a string formatted to be stored
     *
     * @param list  list where data is stored
     * @param index index of data in list
     * @return string formatted to be stored
     */
    private static String formatListDataIntoStorageForm(ArrayList<Task> list, int index) {
        String output;
        String input = list.get(index).getStatusAndDescription();
        switch (input.strip().toCharArray()[INDEX_OF_TASK_TYPE]) {
        case ('T'):
            output = CommandType.TODO.toString() + " " + list.get(index).getDescription();
            break;
        case ('D'):
            output = CommandType.DEADLINE.toString() + " " + list.get(index).getDescription()
                    + DEADLINE_KEYWORD + " " + list.get(index).getAdditionalInformation();
            break;
        case ('E'):
            output = CommandType.EVENT.toString() + " " + list.get(index).getDescription()
                    + EVENT_KEYWORD + " " + list.get(index).getAdditionalInformation();
            break;
        default:
            return "";
        }
        output += " " + list.get(index).getStatusIcon();
        return output;
    }

    /**
     * Writes the data in the text file into list in program
     *
     * @param list  list where data is to be stored in program
     * @param index index of task
     * @param input raw data from the text file
     */
    private void transferDataInToList(ArrayList<Task> list, int index, String input) {
        boolean isDone = input.contains(TICK_ICON);
        if (input.isEmpty()) {
            return;
        }
        // removing status icon from input
        int endOfSubString = input.length() - LENGTH_OFFSET_FOR_STATUS_ICON;
        input = input.substring(0, endOfSubString);

        if (input.startsWith(CommandType.EVENT.toString())) {

            input = GeneralMethods.removeCommandFromInput(input, CommandType.EVENT);
            /* eventInformation[0] = description of event
             * eventInformation[1] = event date
             */
            String[] eventInformation = input.split(EVENT_KEYWORD, NUMBER_OF_PARTS);
            list.add(new Event(eventInformation[0], eventInformation[1].strip()));

        } else if (input.startsWith(CommandType.DEADLINE.toString())) {

            input = GeneralMethods.removeCommandFromInput(input, CommandType.DEADLINE);
            /* deadlineInformation[0] = description of task
             * deadlineInformation[1] = deadline date
             */
            String[] deadlineInformation = input.split(DEADLINE_KEYWORD, NUMBER_OF_PARTS);
            list.add(new Deadline(deadlineInformation[0], deadlineInformation[1].strip()));

        } else if (input.startsWith(CommandType.TODO.toString())) {
            input = GeneralMethods.removeCommandFromInput(input, CommandType.TODO);
            list.add(new ToDo(input));
        }
        if (isDone) {
            list.get(index).markTaskAsDone();
        }
    }
}
