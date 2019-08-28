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
        print_line();
        taskList = new FileManager().LoadFile();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        print_line();
        input();
    }

    static void print_line() {
        for (int i = 0; i < 55; ++i) {
            System.out.print("\u2500");
        }
        System.out.print("\n");
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        List<String> inputList = Arrays.asList(inputLine.split(" "));
        try {
            switch (inputList.get(0)) {
                case "done":
                    if (inputList.size() <= 1) {
                        throw new DukeException("", DukeException.ExceptionType.INVALID_DONE);
                    } else {
                        int listNum = Integer.parseInt(inputList.get(1)) - 1;
                        if (listNum >= 0 && listNum < taskList.size()) {
                            taskList.get(listNum).markDone();
                            Task currTask = taskList.get(listNum);
                            print_line();
                            System.out.println(" Nice! I've marked this task as done:\n" + currTask.toString());
                            print_line();
                            new FileManager().saveFile(taskList);
                            input();
                        } else {
                            throw new DukeException("", DukeException.ExceptionType.OUT_OF_RANGE);
                        }
                    }
                case "delete":
                    int listNum = Integer.parseInt(inputList.get(1)) - 1;
                    if (listNum >= 0 && listNum < taskList.size()) {
                        print_line();
                        System.out.println("Noted. I've removed this task:\n" + taskList.toString() + "\nNow you have " + taskList.size() + " tasks in the list.");
                        print_line();
                        taskList.remove(listNum);
                        new FileManager().saveFile(taskList);
                        input();
                    } else {
                        throw new DukeException("", DukeException.ExceptionType.OUT_OF_RANGE);
                    }
                case "bye":
                    print_line();
                    System.out.println("Bye. Hope to see you again soon!");
                    print_line();
                    new FileManager().saveFile(taskList);
                    System.exit(0);
                case "list":
                    print_line();
                    System.out.println("Here are the tasks in your list:");
                    int counter = 1;
                    for (Task pastTask : taskList) {
                        System.out.println(counter + "." + pastTask.toString());
                        ++counter;
                    }
                    print_line();
                    input();
                case "todo":
                    String description = String.join(" ", inputList.subList(1, inputList.size()));
                    if (description.isBlank()) {
                        throw new DukeException("", DukeException.ExceptionType.INVALID_TODO);
                    }
                    Todo todo = new Todo(description);
                    taskList.add(todo);
                    print_line();
                    System.out.println("Got it. I've added this task:\n" + todo.toString() + "\nNow you have " + taskList.size() + " tasks in the list.\n");
                    print_line();
                    new FileManager().saveFile(taskList);
                    input();
                case "deadline":
                    description = inputList.subList(1, inputList.size()).stream().takeWhile(x -> !x.equals("/by")).collect(Collectors.joining(" "));
                    String by = inputList.subList(1, inputList.size()).stream().dropWhile(x -> !x.equals("/by")).filter(x -> !x.equals("/by")).collect(Collectors.joining(" "));
                    if (description.isBlank()) {
                        throw new DukeException("", DukeException.ExceptionType.INVALID_DEADLINE);
                    }
                    if (by.isBlank()) {
                        throw new DukeException("", DukeException.ExceptionType.DEADLINE_TIME);
                    }
                    System.out.println(by);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(""
                            + "[yyyy/MM/dd HHmm]"
                            + "[yyyy-MM-dd HHmm]"
                            + "[ddMMMyyyy HHmm]"
                            + "[dd/MM/yyyy HHmm]"
                            + "[d/MM/yyyy HHmm]"
                    );
                    LocalDateTime localDateTime = LocalDateTime.parse(by,formatter);
                    Deadline deadline = new Deadline(description, localDateTime);
                    taskList.add(deadline);
                    print_line();
                    System.out.println("Got it. I've added this task:\n" + deadline.toString() + "\nNow you have " + taskList.size() + " tasks in the list.\n");
                    print_line();
                    new FileManager().saveFile(taskList);
                    input();
                case "event":
                    description = inputList.subList(1, inputList.size()).stream().takeWhile(x -> !x.equals("/at")).collect(Collectors.joining(" "));
                    if (description.isBlank()) {
                        throw new DukeException("", DukeException.ExceptionType.INVALID_EVENT);
                    }
                    String at = inputList.subList(1, inputList.size()).stream().dropWhile(x -> !x.equals("/at")).filter(x -> !x.equals("/at")).collect(Collectors.joining(" "));
                    if (at.isBlank()) {
                        throw new DukeException("", DukeException.ExceptionType.EVENT_TIME);
                    }
                    Event event = new Event(description, at);
                    taskList.add(event);
                    print_line();
                    new FileManager().saveFile(taskList);
                    System.out.println("Got it. I've added this task:\n" + event.toString() + "\nNow you have " + taskList.size() + " tasks in the list.\n");
                    new FileManager().saveFile(taskList);
                    print_line();
                    input();
                default:
                    throw new DukeException("", DukeException.ExceptionType.INVALID_COMMAND);
            }
        } catch (DukeException e) {
            e.PrintExceptionMessage();
            input();
        }
    }
}

