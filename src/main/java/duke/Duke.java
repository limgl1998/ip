package duke;

import duke.Command.Parser;
import duke.Command.Ui;
import duke.FileIO.Storage;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner in = new Scanner(System.in);
        boolean endDuke = false;
        Storage storage = new Storage();
        Ui ui = new Ui();

        storage.readFromFile();
        ui.start();
        while (!endDuke) {
            String command = in.nextLine();
            endDuke = Parser.handlesInput(command, true);
        }
        ui.exit();
    }
}
