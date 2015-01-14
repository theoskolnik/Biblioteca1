import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    private PrintStream printStream;
    private Application application;
    private ArrayList<String> books;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        application = new Application(biblioteca);
    }

    @Test
    public void shouldPrintWelcomeWhenApplicationStarts() {
        application.start();
        verify(printStream).println("Welcome to Biblioteca");
    }

    @Test
    public void shouldListBooksOnStart(){
        application.start();
        verify(biblioteca).listBooks();
    }


}