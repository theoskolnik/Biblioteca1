import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Application {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private MainMenu mainMenu;

    public Application(BufferedReader bufferedReader, PrintStream printStream, Biblioteca biblioteca, MainMenu mainMenu) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.mainMenu = mainMenu;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        printStream.print(mainMenu.show());
        processInput(bufferedReader);
    }

    public void processInput(BufferedReader bufferedReader) throws IOException {
        String userInput = bufferedReader.readLine();

        if (userInput.compareTo("1") == 0) {
            biblioteca.listBooks();
        }

    }
}
