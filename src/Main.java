import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Biblioteca library = createLibrary(printStream);

        new Application(printStream, library, new MainMenu(bufferedReader, library)).start();
    }

    private static Biblioteca createLibrary(PrintStream printStream) {
        List<Book> books = new ArrayList<Book>();
        Book harryPotter = new Book("Harry Potter", "J.K. Rowling","1997");
        books.add(harryPotter);
        books.add(harryPotter);
        books.add(harryPotter);
        books.add(harryPotter);
        books.add(new Book("12345678901234567890", "12345678901234567890", "2014"));

        Biblioteca biblioteca = new Biblioteca(books);
        return biblioteca;
    }
}
