import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Parser {

    private String command;
    public String description;
    public String additional;
    private List<String> inputList;

    public void parse() {

    }


    public Parser() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        inputList = Arrays.asList(inputLine.split(" "));
    }

    public String getArgument(){
        if(inputList.size() > 1)
            return inputList.get(1);
        else
            return "";

    }

    public String getCommand() {
        command = inputList.get(0);
        return command;
    }

    public int getIndex() {
        int i = -1;
        try{
            if (inputList.size() <= 1) {
                throw new DukeException("", DukeException.ExceptionType.INVALID_DONE);
            } else {
                i = Integer.parseInt(inputList.get(1)) - 1;
            }
        }catch (DukeException e){
            e.PrintExceptionMessage();
        }
        return i;
    }

    public String buildTodo(){
        description = String.join(" ", inputList.subList(1, inputList.size()));
        return description;
    }

    public void buildDeadline() {
        String line = inputList.subList(1, inputList.size())
                .stream()
                .collect(Collectors.joining(" "));
        String[] descriptionBy = line.split("/by ");
        description = descriptionBy[0];
        additional = descriptionBy[1];

    }

    public void buildEvent() {
        String line = inputList.subList(1, inputList.size())
                .stream()
                .collect(Collectors.joining(" "));
        String[] descriptionBy = line.split("/at ");
        description = descriptionBy[0];
        additional = descriptionBy[1];
    }



}
