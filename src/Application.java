import java.io.PrintStream;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Application {

    private Biblioteca biblioteca;

    public Application(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    private String returnWelcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public void start() {
        System.out.println(returnWelcomeMessage());
        biblioteca.listBooks();
    }
}
