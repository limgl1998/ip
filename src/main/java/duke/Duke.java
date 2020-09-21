package duke;

import duke.Command.Parser;
import duke.Command.Ui;

import java.util.Scanner;

public class Duke {
    private final Ui ui;
    private final Scanner in;

    public Duke() {
        ui = new Ui();
        in = new Scanner(System.in);
    }

    public void runUntilByeCommand() {
        boolean endDuke = false;
        Parser parser = new Parser();

        while (!endDuke) {
            String command = in.nextLine();
            endDuke = parser.handlesInput(command, true);
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
