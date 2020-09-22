package duke;

import duke.Command.Parser;
import duke.Command.Ui;
import duke.Tasks.TaskList;

import java.util.Scanner;

public class Duke {
    private final Ui ui;
    private final Scanner in;
    private final TaskList list;

    public Duke() {
        ui = new Ui();
        in = new Scanner(System.in);
        list = new TaskList();
    }

    /**
     * Program continuously prompt the user for inputs until
     * commmand "bye" is keyed in
     */
    public void runUntilByeCommand() {
        boolean endDuke = false;
        Parser parser = new Parser(list);

        while (!endDuke) {
            String command = in.nextLine();
            endDuke = parser.handlesInput(command);
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
