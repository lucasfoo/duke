import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private static List<String> taskList = new ArrayList<>();
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
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        print_line();
        input();
    }

    private static void print_line(){
        for (int i = 0; i < 55; ++i) {
            System.out.print("\u2500");
        }
        System.out.print("\n");
    }

    private static void input(){ Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        if(inputLine.equals("bye")){
            print_line();
            System.out.println("Bye. Hope to see you again soon!");
            print_line();
            System.exit(0);
        }else if(inputLine.equals("list")){
            print_line();
            int counter = 1;
            for (String pastTasks : taskList){
                System.out.println(counter + ". " + pastTasks);
                ++counter;
            }
            print_line();
            input();
        }else{
            taskList.add(inputLine);
            print_line();
            System.out.println("added: " + inputLine);
            print_line();
            input();
        }

    }
}

