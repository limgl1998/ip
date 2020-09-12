package duke.FileIO;

import duke.Command.HandleInput;
import duke.Tasks.Task;
import duke.Tasks.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
    public static void readFromFile() {
        if (!doesFileExist()) {
            return;
        }
        File data = new File("data/data.txt");
        try {
            Scanner s = new Scanner(data); // create a Scanner using the File as the source
            while (s.hasNext()) {
                HandleInput.handlesInput(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("\u2639 OOPS!!! File does not exist. Please create a text file named \"data\" in the \"data\" folder.");
        }
    }

    private static boolean doesFileExist() {
        File folder = new File("data");
        if (!folder.exists()) {
            System.out.println("\u2639 OOPS!!! Folder does not exist. Creating a folder named \"data\" in the same directory...");
            boolean isFolderCreatedSuccessfully = folder.mkdir();
            if (isFolderCreatedSuccessfully) {
                System.out.println("Folder is created successfully.");
            } else {
                System.out.println("Please create a folder named \"data\" in the same directory manually.");
                return false;
            }
        }
        File data = new File("data/data.txt");
        if (!data.exists()) {
            System.out.println("\u2639 OOPS!!! File does not exist. Creating a text file named \"data\" in the \"data\" folder...");
            try {
                FileWriter fw = new FileWriter(data.getAbsolutePath());
                if (data.exists()) {
                    System.out.println("File is created successfully.");
                } else {
                    System.out.println("Please create a text file named \"data\" in the \"data\" folder manually.");
                }
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public static void writeToFile(TaskList taskList) {
        if (!doesFileExist()) {
            return;
        }
        File data = new File("data/data.txt");
        try {
            FileWriter fw = new FileWriter(data.getAbsolutePath());
            Task[] list = taskList.getList();
            for (int i = 0; i < taskList.getNumberOfTasks(); i++) {
                String input = handleStatusAndDescription(list, i);
                fw.write(input + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("OOPS!!! something went wrong"); //remember to change this
        }
    }

    private static String handleStatusAndDescription(Task[] list, int index) {
        String output;
        String input = list[index].getStatusAndDescription();
        switch (input.strip().toCharArray()[1]) {
        case ('T'):
            output = "todo " + list[index].getDescription();
            break;
        case ('D'):
            output = "deadline " + list[index].getDescription() + "/by " + list[index].getAdditionalInfomation();
            break;
        case ('E'):
            output = "event " + list[index].getDescription() + "/at " + list[index].getAdditionalInfomation();
            break;
        default:
            return null;
        }
        if (list[index].getDone()) {
            output += "\ndone " + (index + 1);
        }
        return output;
    }
}
