import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Biblioteca {
    List<Book> books = new ArrayList<Book>();

    public Biblioteca(List<Book> books) {
        this.books = books;
    }

    public String listBooks() {
        String tempString = "";

        for (Book book : books) {
           tempString = tempString + book.getInformation() + "\n";
        }
        return tempString;
    }
}
