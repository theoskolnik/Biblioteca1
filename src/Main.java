import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Biblioteca library = createLibrary(printStream);
        ListBooksCommand listBooksCommand = new ListBooksCommand(library, printStream);
        QuitCommand quitCommand = new QuitCommand();
        InvalidInputCommand invalidInputCommand = new InvalidInputCommand();
        Map<String, Command> menuCommands = new HashMap<String, Command>();
        menuCommands.put("1", listBooksCommand);
        menuCommands.put("2", quitCommand);

        new Application(printStream, library, new MainMenu(bufferedReader, menuCommands, printStream), quitCommand).start();
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
