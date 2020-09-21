package duke;

import duke.Command.Parser;
import duke.Command.Ui;
import duke.FileIO.Storage;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean endDuke = false;

        Storage.readFromFile();
        Ui.start();
        while (!endDuke) {
            String command = in.nextLine();
            endDuke = Parser.handlesInput(command,true);
        }
        Ui.exit();
    }
}
