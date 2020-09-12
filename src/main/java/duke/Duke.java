package duke;

import duke.Command.HandleInput;
import duke.Command.Message;
import duke.FileIO.FileIO;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean endDuke = false;

        FileIO.readFromFile();
        Message.start();
        while (!endDuke) {
            String command = in.nextLine();
            endDuke = HandleInput.handlesInput(command,true);
        }
        Message.exit();
    }
}
