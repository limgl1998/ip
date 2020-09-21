package duke.Command;

/**
 *  Only type of commands allowed
 *  All other commands not found in this list
 *  are treated as invalid
 */

public enum CommandType {
    TODO, EVENT, DEADLINE, DONE, DELETE, FIND, LIST, BYE
}
