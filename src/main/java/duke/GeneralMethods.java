package duke;

import duke.Command.CommandType;

public class GeneralMethods {

    /**
     * Returns input with the given command removed
     *
     * @param input user input
     * @param command one of the defined commands
     * @return user input without command keyword
     */

    public static String removeCommandFromInput(String input, CommandType command) {
        int commandLength = command.toString().length();
        input = input.strip();
        input = input.substring(commandLength);
        input = input.strip();
        return input;
    }

    /**
     * Checks if the input command is a number
     *
     * @param command user input
     * @return whether user input does not contains any non-numeric
     */
    public static boolean isNumeric(String command) {
        if (command.isEmpty()) {
            return false;
        }
        for (char c : command.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
