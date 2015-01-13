import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private ArrayList<String> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(books, printStream);
    }

    @Test
    public void testStart() throws Exception {
        biblioteca.start();
        verify(printStream).println("Welcome to Biblioteca");
    }

    @Test
    public void listsBooksOnStart(){
        biblioteca.listBooks();
        verify(printStream, times(0)).println(anyString());
    }

    @Test
    public  void listsOneBookOnStart(){
        books.add("Harry Potter");
        biblioteca.listBooks();
        verify(printStream).println("Harry Potter");
    }

    @Test
    public void  listsMultipleBooksOnStart(){
        books.add("Lord of the Rings");
        books.add("Harry Potter");
        biblioteca.listBooks();
        verify(printStream).println("Lord of the Rings");
        verify(printStream).println("Harry Potter");
    }
}