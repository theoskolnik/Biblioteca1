import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Application {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private MainMenu mainMenu;
    private Quitter quitter;

    public Application(PrintStream printStream, Biblioteca biblioteca, MainMenu mainMenu, Quitter quitter) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.mainMenu = mainMenu;
        this.quitter = quitter;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        printStream.println(mainMenu.show());
        running();
    }

    public void running() throws IOException {

        while (!quitter.isApplicationDone()) {
            // show menu
            // get user input
                // if input is invalid
                // print message
                // ask for input again

            // repeat
            
            Integer action = mainMenu.processInput();
            while (action == -1) {
                if (action == -1) {
                    printStream.println("Select a valid option!");
                    printStream.println(mainMenu.show());
                    action = mainMenu.processInput();
                }
            }
            if (action == 2) {
                printStream.println("You've quit Biblioteca.");
            }
        }
    }

}
