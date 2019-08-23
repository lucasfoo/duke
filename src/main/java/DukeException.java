import java.lang.reflect.Type;

public class DukeException extends Exception {
    enum ExceptionType{
        INVALID_COMMAND,
        INVALID_TODO,
        INVALID_DEADLINE,
        INVALID_EVENT,
        DEADLINE_TIME,
        EVENT_TIME,
        OUT_OF_RANGE
    }

    private ExceptionType type;

    public DukeException(String message, ExceptionType type){
        super(message);
        this.type = type;
    }

    public void PrintExceptionMessage(){
        if(this.type.equals( ExceptionType.INVALID_COMMAND)){
            Duke.print_line();
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            Duke.print_line();
        }else if(this.type.equals(ExceptionType.INVALID_TODO)){
            Duke.print_line();
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
            Duke.print_line();
        }else if (this.type.equals(ExceptionType.INVALID_DEADLINE)){
            Duke.print_line();
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
            Duke.print_line();
        }else if(this.type.equals(ExceptionType.INVALID_EVENT)){
            Duke.print_line();
            System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
            Duke.print_line();
        }else if(this.type.equals(ExceptionType.EVENT_TIME)){
            Duke.print_line();
            System.out.println("☹ OOPS!!! The time of a event cannot be empty.");
            Duke.print_line();
        }else if(this.type.equals(ExceptionType.DEADLINE_TIME)){
            Duke.print_line();
            System.out.println("☹ OOPS!!! The time of a deadline cannot be empty.");
            Duke.print_line();
        }else if (this.type.equals(ExceptionType.OUT_OF_RANGE)){
            Duke.print_line();
            System.out.println("☹ OOPS!!! THe item you have selected is out of range.");
            Duke.print_line();
        }
    }
}
