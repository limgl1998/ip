package duke;

import duke.Command.HandleInput;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Message.start();
        String command = in.nextLine();
        while (!command.equalsIgnoreCase("bye")) {
            HandleInput.handlesInput(command);
            command = in.nextLine();
        }
        Message.exit();

    }
}
