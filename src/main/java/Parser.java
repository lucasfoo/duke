import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Parser {

    private String command;
    private String description;
    private String additional;
    private List<String> inputList;

    public void parse() {

    }


    public Parser() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        inputList = Arrays.asList(inputLine.split(" "));
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

    public String buildTodoDescription(){
        description = String.join(" ", inputList.subList(1, inputList.size()));
        return description;
    }

    public String buildDeadlineDescription() {
        return inputList.subList(1, inputList.size())
                .stream()
                .takeWhile(x -> !x.equals("/by"))
                .collect(Collectors.joining(" "));
    }

    public String buildDeadlineBy(){
        String by = inputList.subList(1, inputList.size())
                .stream()
                .dropWhile(x -> !x.equals("/by"))
                .filter(x -> !x.equals("/by"))
                .collect(Collectors.joining(" "));
        additional = by;
        return additional;
    }

    public String buildEventDescription() {
        return inputList.subList(1, inputList.size())
                .stream()
                .takeWhile(x -> !x.equals("/at"))
                .collect(Collectors.joining(" "));
    }

    public String buildEventAt(){
        String at = inputList.subList(1, inputList.size())
                .stream().dropWhile(x -> !x.equals("/at"))
                .filter(x -> !x.equals("/at"))
                .collect(Collectors.joining(" "));
        additional = at;
        return additional;
    }


}
