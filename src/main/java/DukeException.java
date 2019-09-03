import java.lang.reflect.Type;

public class DukeException extends Exception {
    enum ExceptionType{
        INVALID_COMMAND,
        INVALID_TODO,
        INVALID_DEADLINE,
        INVALID_EVENT,
        DEADLINE_TIME,
        EVENT_TIME,
        OUT_OF_RANGE,
        INVALID_DONE,
        UNKNOWN
    }

    private ExceptionType type;

    public DukeException(String message, ExceptionType type){
        super(message);
        this.type = type;
    }

    public void PrintExceptionMessage(){
        if(this.type.equals( ExceptionType.INVALID_COMMAND)){
            InputParser.print_line();
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            InputParser.print_line();
        }else if(this.type.equals(ExceptionType.INVALID_TODO)){
            InputParser.print_line();
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
            InputParser.print_line();
        }else if (this.type.equals(ExceptionType.INVALID_DEADLINE)){
            InputParser.print_line();
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
            InputParser.print_line();
        }else if(this.type.equals(ExceptionType.INVALID_EVENT)){
            InputParser.print_line();
            System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
            InputParser.print_line();
        }else if(this.type.equals(ExceptionType.EVENT_TIME)){
            InputParser.print_line();
            System.out.println("☹ OOPS!!! The time of a event cannot be empty.");
            InputParser.print_line();
        }else if(this.type.equals(ExceptionType.DEADLINE_TIME)){
            InputParser.print_line();
            System.out.println("☹ OOPS!!! The time of a deadline cannot be empty.");
            InputParser.print_line();
        }else if (this.type.equals(ExceptionType.OUT_OF_RANGE)){
            InputParser.print_line();
            System.out.println("☹ OOPS!!! THe item you have selected is out of range.");
            InputParser.print_line();
        }else if(this.type.equals(ExceptionType.UNKNOWN)){
            System.out.println("☹ OOPS!!! WTF SOMETHING WEIRED HAPPENED");
        }else if(this.type.equals(ExceptionType.INVALID_DONE)) {
            InputParser.print_line();
            System.out.println("☹ OOPS!!! The index of mark as done cannot be empty.");
            InputParser.print_line();
        }
    }
}
