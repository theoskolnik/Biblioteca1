import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BibliotecaTest {
    private List<Book> books;
    private Biblioteca biblioteca;
    private PrintStream printStream;

    @Before
    public void setUp() {
        books = new ArrayList<Book>();
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(books);
    }

    @Test
    public  void listsOneBookOnStart(){
        Book book = mock(Book.class);
        when(book.getInformation()).thenReturn("Blah");
        books.add(book);
        String books = biblioteca.listBooks();
        assertThat(books, is("Blah\n"));
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

        String books = biblioteca.listBooks();

        assertThat(books, is("123\n456\n"));
    }

}