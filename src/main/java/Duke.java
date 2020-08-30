import java.util.Scanner;

public class Duke {

    public static void start(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    public static void exit(){
        System.out.println("    ____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }

    public static void handlesCommand(String command, TaskList list){

        System.out.println("    ____________________________________________________________");
        if (command.equals("list")) {
            list.printTaskList();
        } else {
            list.addTask(command);
        }
        System.out.println("    ____________________________________________________________");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskList list = new TaskList();

        start();
        String command = in.nextLine();
        while (!command.equals("bye")) {
            handlesCommand(command,list);
            command = in.nextLine();
        }

        exit();

    }
}
