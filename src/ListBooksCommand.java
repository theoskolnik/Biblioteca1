import java.io.PrintStream;

/**
 * Created by tskolnik on 1/20/15.
 */
public class ListBooksCommand implements Command {


    private Biblioteca biblioteca;
    private PrintStream printStream;

    public ListBooksCommand(Biblioteca biblioteca, PrintStream printStream) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println(biblioteca.listBooks());
    }

    @Override
    public String name() {
        return "List Books";
    }
}
