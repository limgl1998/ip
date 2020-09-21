package duke.Command;

/**
 *  Only type of commands allowed
 *  All other commands not found in this list
 *  is treated as invalid
 */

public enum CommandType {
    todo, event, deadline, done, delete, find
}
