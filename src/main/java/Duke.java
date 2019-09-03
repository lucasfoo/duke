import java.io.File;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Duke {
    private static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
         */
        InputParser.print_line();
        taskList = new FileManager().LoadFile();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        InputParser.print_line();
        new InputParser().input(taskList);
    }



}

