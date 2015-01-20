import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tbartlett on 1/14/15.
 */
public class MainMenu {
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private final Integer invalidInput = -1;
    private final Integer listBooksInput = 1;
    private final Integer quitInput = 2;


    private Map<String, Command> menuCommands = new HashMap<String, Command>();


    public MainMenu(BufferedReader bufferedReader, Biblioteca biblioteca) {

        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;

        menuCommands.put("1", new ListBooksCommand(biblioteca));
        menuCommands.put("2", new QuitCommand());
    }

    public String show() {
        return "1. List Books \n2. Quit";

    }

    public Integer processInput() throws IOException {
        // List menu options here

        for (String key : menuCommands.keySet()) {
            System.out.println(key + ". " + menuCommands.get(key).name() );
        }
        String userInput = bufferedReader.readLine();

        if(menuCommands.containsKey(userInput)){
            Command command = menuCommands.get(userInput);
            command.execute();
        }

        if (userInput.compareTo("1") == 0) {
            return listBooksInput;
        } else if(userInput.compareTo("2") == 0) {
            return quitInput;
        } else {
            return invalidInput;
        }
    }
}
