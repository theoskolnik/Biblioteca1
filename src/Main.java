import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        new Application(createLibrary(printStream)).start();

    }

    private static Biblioteca createLibrary(PrintStream printStream) {
        List<Book> books = new ArrayList<Book>();
        Book harryPotter = new Book("Harry Potter", "J.K. Rowling","1997");
        books.add(harryPotter);
        books.add(harryPotter);
        books.add(harryPotter);
        books.add(harryPotter);
        books.add(new Book("12345678901234567890", "12345678901234567890", "2014"));

        Biblioteca biblioteca = new Biblioteca(books, printStream);
        return biblioteca;
    }
}
