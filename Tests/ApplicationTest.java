import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    private PrintStream printStream;
    private Application application;
    private ArrayList<String> books;
    private Biblioteca biblioteca;
    private MainMenu menu;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<String>();
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        menu = mock(MainMenu.class);
        bufferedReader = mock(BufferedReader.class);
        application = new Application(bufferedReader, printStream, biblioteca, menu);
    }

    @Test
    public void shouldPrintWelcomeWhenApplicationStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        application.start();
        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldDisplayMainMenuWhenApplicationStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        application.start();
        verify(menu).show();
    }

    @Test
    public void shouldListBooksWhenListBooksOptionIsChosen() throws IOException {
        menu.show();
        when(bufferedReader.readLine()).thenReturn("1");
        application.processInput(bufferedReader);
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldNotListBooksWhenListBooksOptionIsNotChosen() throws IOException {
        menu.show();
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("2");
        application.processInput(bufferedReader);
        verify(biblioteca, times(0)).listBooks();
    }


}