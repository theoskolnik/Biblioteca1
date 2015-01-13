import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printStream);
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
}