import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {
    private List<Book> books;
    private Biblioteca biblioteca;
    private PrintStream printStream;

    @Before
    public void setUp() {
        books = new ArrayList<Book>();
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(books, printStream);
    }

    @Test
    public  void listsOneBookOnStart(){
        Book harryPotter = new Book("Harry Potter", "J.K. Rowling", "1997");
        books.add(harryPotter);
        biblioteca.listBooks();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t1997");
    }

    @Test
    public void  listsMultipleBooksOnStart(){
        Book harryPotter = new Book("Harry Potter", "J.K. Rowling", "1997");
        Book lotr = new Book("Lord of the Rings", "J.R.R. Tolkien", "1982");
        books.add(harryPotter);
        books.add(lotr);
        biblioteca.listBooks();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t1997");
        verify(printStream).println("Lord of the Rings\tJ.R.R. Tolkien\t1982");
    }

}