import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuTest {

    private MainMenu menu;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private ListBooksCommand listBooksCommand;

    @Before
    public void SetUp(){
        bufferedReader= mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = new MainMenu(bufferedReader, biblioteca);
        listBooksCommand = mock(ListBooksCommand.class);
    }

//    @Test
//    public void shouldDisplayMenuWhenCalled(){
//        MainMenu m = mock(MainMenu.class);
//        when(m.show()).thenReturn("123");
//        assertThat(m.show(), is("123"));
//    }


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

    @Test
     public void shouldTestIfQuitIsAMenuOption() {
        String menuOutput = menu.show();
        assertEquals(menuOutput.contains("Quit"), true);
    }

    @Test
    public void shouldReturnTwoWhenUserSelectsQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        assertThat(menu.processInput(), is(2));
    }

}