import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by tbartlett on 1/14/15.
 */
public class MainMenu {
    private BufferedReader bufferedReader;
    private Map<String, Command> menuCommands;
    private PrintStream printStream;
    private final Integer invalidInput = -1;
    private final Integer listBooksInput = 1;
    private final Integer quitInput = 2;

    public MainMenu(BufferedReader bufferedReader, Map<String, Command> menuCommands, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.menuCommands = menuCommands;
        this.printStream = printStream;
    }

    public String show() {
        String returnString = "";
        for (String key : menuCommands.keySet()) {
            returnString = key + ". " + menuCommands.get(key).name() + "\n" + returnString;
        }
        return returnString;
    }

    public void processInput() throws IOException {
        // List menu options here

//        for (String key : menuCommands.keySet()) {
//            System.out.println(key + ". " + menuCommands.get(key).name() );
//        }
        String userInput = bufferedReader.readLine();
//
//        if(menuCommands.containsKey(userInput)){
//            Command command = menuCommands.get(userInput);
//            command.execute();
//        }

        if (userInput.compareTo("1") == 0) {
            menuCommands.get(userInput).execute();
//            return listBooksInput;
        } else if (userInput.compareTo("2") == 0) {
            menuCommands.get(userInput).execute();
//            return quitInput;
        } else {
            printStream.println("Select a valid option!");
//            return invalidInput;
        }
    }
}
