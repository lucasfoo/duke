import java.util.Scanner;

public class Duke {
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
        }else{
            print_line();
            System.out.println(inputLine);
            print_line();
            input();
        }
    }
}

