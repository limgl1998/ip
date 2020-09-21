package duke;

import duke.Command.CommandType;

public class GeneralMethods {

    /**
     * Returns input with the given command removed
     *
     * @param input
     * @param command
     * @return
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
     * @param command
     * @return
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
