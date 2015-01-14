import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Biblioteca {
    List<Book> books = new ArrayList<Book>();
    private PrintStream printStream;

    public Biblioteca(List<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void listBooks() {
        for (int i = 0; i < books.size(); i++) {
            printStream.println(books.get(i).getInformation());
        }
    }
}
