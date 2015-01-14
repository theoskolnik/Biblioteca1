import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        Book book = mock(Book.class);
        books.add(book);
        biblioteca.listBooks();
        verify(printStream).println(book.getInformation());
    }

    @Test
    public void  listsMultipleBooksOnStart(){
        String bookInfo = "BookInfo";
        Book book = mock(Book.class);
        when(book.getInformation()).thenReturn("123");
        Book book2 = mock(Book.class);
        when(book2.getInformation()).thenReturn("456");
        books.add(book);
        books.add(book2);

        biblioteca.listBooks();

        verify(printStream).println(book.getInformation());
        verify(printStream).println(book2.getInformation());
    }

}