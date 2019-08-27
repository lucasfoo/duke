import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class FileManager {
    public void saveFile(List<Task> taskList) {
        try {
            PrintStream stdout = System.out;
            PrintStream fileOut = new PrintStream("./savefile.txt");
            System.setOut(fileOut);
            for (Task pastTask : taskList){
                if(pastTask instanceof Todo){
                    System.out.println("T | " + (pastTask.isDone ? 1 : 0) + " | " + pastTask.description);
                }else if(pastTask instanceof  Deadline){
                    System.out.println("T | " + (pastTask.isDone ? 1 : 0) + " | " + pastTask.description + " | " + ((Deadline) pastTask).by);
                }else if (pastTask instanceof  Event){
                    System.out.println("T | " + (pastTask.isDone ? 1 : 0) + " | " + pastTask.description + " | " + ((Event) pastTask).at);
                }
            }
            System.setOut(stdout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
