import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private MainMenu menu;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private ListBooksCommand listBooksCommand;
    private QuitCommand quitCommand;
    private InvalidInputCommand invalidInputCommand;
    private PrintStream printStream;

    @Before
    public void SetUp(){
        bufferedReader= mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        listBooksCommand = mock(ListBooksCommand.class);
        quitCommand = mock(QuitCommand.class);
        invalidInputCommand = mock(InvalidInputCommand.class);
        printStream = mock(PrintStream.class);
        Map<String, Command> menuCommands = new HashMap<String, Command>();
        menuCommands.put("1", listBooksCommand);
        menuCommands.put("2", quitCommand);
        menu = new MainMenu(bufferedReader, menuCommands, printStream);
    }

    @Test
    public void shouldDisplayMenuWhenCalled(){
        when(listBooksCommand.name()).thenReturn("List Books");
        when(quitCommand.name()).thenReturn("Quit");
        String menuString = menu.show();
        assertThat(menuString, is("1. " + listBooksCommand.name() +  "\n2. " + quitCommand.name() + "\n"));
    }

    @Test
    public void shouldReturnListBooksEnumerationWhenListBooksOptionIsChosen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.processInput();
        verify(listBooksCommand).execute();
    }

    @Test
     public void shouldTestIfQuitIsAMenuOption() {
        when(quitCommand.name()).thenReturn("Quit");
        String menuOutput = menu.show();
        assertThat(menuOutput.contains("Quit"), is(true));
    }

    @Test
    public void shouldExecuteCommandWhenUserEntersValidCommandKey() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        menu.processInput();
        verify(quitCommand).execute();
    }

    @Test
    public void shouldCallInvalidUserInputCommandExecuteWhenUserEntersTheo() throws IOException {
        // pass an empty map and select anything and print invalid message
        // or pass a map that has something in it and call execute on mock
        when(bufferedReader.readLine()).thenReturn("Theo");
        menu.processInput();
        verify(printStream).println("Select a valid option!");
    }

}