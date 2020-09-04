public class GeneralMethods {

    public static String removeCommandFromInput(String input, CommandType command) {
        int commandLength = command.toString().length();
        input = input.strip();
        input = input.substring(commandLength);
        input = input.strip();
        return input;
    }

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
