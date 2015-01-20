import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private MainMenu menu;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private ListBooksCommand listBooksCommand;
    private QuitCommand quitCommand;

    @Before
    public void SetUp(){
        bufferedReader= mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        listBooksCommand = mock(ListBooksCommand.class);
        quitCommand = mock(QuitCommand.class);
        menu = new MainMenu(bufferedReader, biblioteca, listBooksCommand, quitCommand);
    }

    @Test
    public void shouldDisplayMenuWhenCalled(){
        when(listBooksCommand.name()).thenReturn("List Books");
        String menuString = menu.show();
        assertThat(menuString, is("1. " + listBooksCommand.name() +  "\n"));
    }


    @Test
    public void shouldReturnListBooksEnumerationWhenListBooksOptionIsChosen() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.processInput();
        verify(listBooksCommand).execute();
    }

    @Test
    public void shouldReturnAnInvalidEnumWhenUserInputIsInvalid() throws IOException {
        menu.show();
        when(bufferedReader.readLine()).thenReturn("98765");
        Integer interpretationOfUserInput = menu.processInput();
        assertThat(interpretationOfUserInput, is(-1));
    }
//
//    @Test
//     public void shouldTestIfQuitIsAMenuOption() {
//        String menuOutput = menu.show();
//        assertEquals(menuOutput.contains("Quit"), true);
//    }

    @Test
    public void shouldReturnTwoWhenUserSelectsQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        assertThat(menu.processInput(), is(2));
    }

    @Test
    public void shouldCallQuitCommandExecuteWhenUserSelectsQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        menu.processInput();
        verify(quitCommand).execute();
    }

}