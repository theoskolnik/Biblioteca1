import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Application {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private MainMenu mainMenu;

    public Application(PrintStream printStream, Biblioteca biblioteca, MainMenu mainMenu) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.mainMenu = mainMenu;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        printStream.println(mainMenu.show());
        running();
    }

    public void running() throws IOException {
        Integer action = mainMenu.processInput();
        while(action == 1 || action == -1) {
            if (action == -1) {
                printStream.println("Select a valid option!");
                printStream.println(mainMenu.show());
                action = mainMenu.processInput();
            } else {
                printStream.println(biblioteca.listBooks());
                action = mainMenu.processInput();
            }
        }
        if (action == 2) {
            printStream.println("You've quit Biblioteca.");
        }
    }

}
