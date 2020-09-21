package duke;

import duke.Command.Parser;
import duke.Command.Ui;
import duke.FileIO.Storage;

import java.util.Scanner;

public class Duke {
    private Ui ui;
    private Scanner in;
    private Storage storage;

    public Duke() {
        ui = new Ui();
        in = new Scanner(System.in);
        storage = new Storage();
    }

    public void runUntilByeCommand() {
        boolean endDuke = false;

        storage.readFromFile();
        while (!endDuke) {
            String command = in.nextLine();
            endDuke = Parser.handlesInput(command, true);
        }
    }

    private void start() {
        ui.printStart();
    }

    private void end() {
        ui.printExit();
    }

    public void run() {
        start();
        runUntilByeCommand();
        end();
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
