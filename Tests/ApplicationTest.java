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
    private ArrayList<Book> books;
    private Biblioteca biblioteca;
    private MainMenu menu;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
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
    public  void shouldListBooksWhenListBooksOptionIsChosen() throws IOException {
        when(biblioteca.listBooks()).thenReturn("books are listed");
        when(menu.processInput()).thenReturn(1).thenReturn(2);
        application.running();
        verify(printStream).println("books are listed");
    }

    @Test
    public void shouldDisplayInvalidOptionErrorWhenInvalidOptionIsChosen() throws IOException {
        when(menu.processInput()).thenReturn(-1).thenReturn(2);
        application.running();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldDisplayMenuAgainAfterInvalidOptionChosen() throws IOException {
        when(menu.processInput()).thenReturn(-1).thenReturn(2);
        application.running();
        verify(printStream).println(menu.show());
    }

    @Test
    public void shouldAcceptInputAfterInvalidInput() throws IOException {
        when(menu.processInput()).thenReturn(-1).thenReturn(2);
        application.running();
        verify(menu, times(2)).processInput();
    }

    @Test
    public void shouldAskUserForInputUntilUserSelectsQuitOption() throws IOException {
        when(menu.processInput()).thenReturn(1).thenReturn(2);
        application.running();
        verify(menu, times(2)).processInput();
    }

    @Test
    public void shouldPrintAQuitMessageWhenUserSelectsQuitOption() throws IOException {
        when(menu.processInput()).thenReturn(2);
        application.running();
        verify(printStream).println("You've quit Biblioteca.");
    }


}