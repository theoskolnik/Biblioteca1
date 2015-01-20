/**
 * Created by tskolnik on 1/20/15.
 */
public class ListBooksCommand implements Command {


    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {

        biblioteca.listBooks();

    }

    @Override
    public String name() {
        return null;
    }
}
