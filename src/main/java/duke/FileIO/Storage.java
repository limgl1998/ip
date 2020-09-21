package duke.FileIO;

import duke.Command.Parser;
import duke.Command.Ui;
import duke.Tasks.Task;
import duke.Tasks.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private static final int INDEX_OF_TASK_TYPE = 1;
    private Ui ui = new Ui();
    /**
     * Loads data from save file
     */
    public void readFromFile() {
        if (doesFileNotExist()) {
            return;
        }
        File data = new File("data/data.txt");
        try {
            Scanner s = new Scanner(data); // create a Scanner using the File as the source
            while (s.hasNext()) {
                Parser.handlesInput(s.nextLine(), false);
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
     * @return file exist or not
     */
    private boolean doesFileNotExist() {
        File folder = new File("data");
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
        File data = new File("data/data.txt");
        if (!data.exists()) {
            ui.printFileNotFound();
            try {
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
     * Writes data from the tasklist into the save file
     *
     * @param taskList
     */

    public void writeToFile(TaskList taskList) {
        if (doesFileNotExist()) {
            return;
        }
        File data = new File("data/data.txt");
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

    private static String formatListDataIntoStorageForm(ArrayList<Task> list, int index) {
        String output;
        String input = list.get(index).getStatusAndDescription();
        switch (input.strip().toCharArray()[INDEX_OF_TASK_TYPE]) {
        case ('T'):
            output = "todo " + list.get(index).getDescription();
            break;
        case ('D'):
            output = "deadline " + list.get(index).getDescription()
                    + "/by " + list.get(index).getAdditionalInformation();
            break;
        case ('E'):
            output = "event " + list.get(index).getDescription()
                    + "/at " + list.get(index).getAdditionalInformation();
            break;
        default:
            return null;
        }
        if (list.get(index).getDone()) {
            output += "\ndone " + (index + 1);
        }
        return output;
    }
}
