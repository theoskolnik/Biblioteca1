import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Application {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private Quitter quitter;

    public Application(PrintStream printStream, MainMenu mainMenu, Quitter quitter) {
        this.printStream = printStream;
        this.mainMenu = mainMenu;
        this.quitter = quitter;
    }

    public void start() throws IOException {
        printStream.println("Welcome to Biblioteca!");
        running();
    }

    public void running() throws IOException {

        while (!quitter.isApplicationDone()) {
            printStream.println(mainMenu.show());
            mainMenu.processInput();
        }
    }

}
