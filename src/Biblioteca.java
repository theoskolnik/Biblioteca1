import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Biblioteca {

    ArrayList<String> books = new ArrayList<String>();
    PrintStream printStream;

    public Biblioteca(ArrayList<String> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca");
        listBooks();
    }

    public void listBooks() {
        for (int i = 0; i < books.size(); i++) {
            printStream.println(books.get(i));
        }
    }


}
