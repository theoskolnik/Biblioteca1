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
    private Quitter quitter;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        menu = mock(MainMenu.class);
        bufferedReader = mock(BufferedReader.class);
        quitter = mock(Quitter.class);
        application = new Application(printStream, biblioteca, menu, quitter);
    }


    @Test
    public void shouldPrintWelcomeWhenApplicationStarts() throws IOException {
        runApplicationOnce();
        when(bufferedReader.readLine()).thenReturn("1");
        application.start();
        verify(printStream).println("Welcome to Biblioteca!");
    }


    @Test
    public void shouldDisplayMainMenuWhenApplicationStarts() throws IOException {
        runApplicationOnce();
        when(bufferedReader.readLine()).thenReturn("1");
        application.start();
        verify(menu).show();
    }

    @Test
    public void shouldDisplayInvalidOptionErrorWhenInvalidOptionIsChosen() throws IOException {
        runApplicationOnce();
        when(menu.processInput()).thenReturn(-1).thenReturn(2);
        application.running();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldDisplayMenuAgainAfterInvalidOptionChosen() throws IOException {
        runApplicationOnce();
        when(menu.processInput()).thenReturn(-1).thenReturn(2);
        application.running();
        verify(printStream).println(menu.show());
    }

    @Test
    public void shouldAcceptInputAfterInvalidInput() throws IOException {
        runApplicationOnce();
        when(menu.processInput()).thenReturn(-1).thenReturn(2);
        application.running();
        verify(menu, times(2)).processInput();
    }

    @Test
    public void shouldAskUserForInputUntilUserSelectsQuitOption() throws IOException {
        runApplicationOnce();
        when(menu.processInput()).thenReturn(1).thenReturn(2);
        application.running();
        verify(menu, times(2)).processInput();
    }

    @Test
    public void shouldPrintAQuitMessageWhenUserSelectsQuitOption() throws IOException {
        runApplicationOnce();
        when(menu.processInput()).thenReturn(2);
        application.running();
        verify(printStream).println("You've quit Biblioteca.");
    }

    @Test
    public void shouldNeverCallProcessInputWhenApplicationDoneFlagIsTrue() throws IOException {
        runApplicationZeroTimes();
        application.running();
        verify(menu, never()).processInput();
    }

    private void runApplicationZeroTimes() {
        when(quitter.isApplicationDone()).thenReturn(true);
    }

    private void runApplicationOnce() {
        when(quitter.isApplicationDone()).thenReturn(false).thenReturn(true);
    }

}