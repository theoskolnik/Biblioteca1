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
        application = new Application(printStream, biblioteca, menu);
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
    public void shouldDisplayInvalidOptionErrorWhenInvalidOptionIsChosen() throws IOException {
        when(menu.processInput()).thenReturn(-1);
        application.running();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldDisplayMenuAgainAfterInvalidOptionChosen() throws IOException {
        when(menu.processInput()).thenReturn(-1);
        application.running();
        verify(printStream).print(menu.show());
    }

    @Test
    public void shouldAcceptInputAfterInvalidInput() throws IOException {
        when(menu.processInput()).thenReturn(-1);
        verify(bufferedReader).readLine();
    }

}