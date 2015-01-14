import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.bugspot.BugSpot;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainMenuTest {

    private MainMenu menu;
    private BufferedReader bufferedReader;

    @Before
    public void SetUp(){
        bufferedReader= mock(BufferedReader.class);
        menu = new MainMenu(bufferedReader);
    }
    @Test
    public void shouldDisplayMenuWhenCalled(){
        String menuString = menu.show();
        assertThat(menuString, is("1. List Books"));
    }


    @Test
    public void shouldReturnListBooksEnumerationWhenListBooksOptionIsChosen() throws IOException {
        menu.show();
        when(bufferedReader.readLine()).thenReturn("1");
        Integer interpretationOfUserInput = menu.processInput();
        assertThat(interpretationOfUserInput, is(1));
    }

    @Test
    public void shouldReturnAnInvalidEnumWhenUserInputIsInvalid() throws IOException {
        menu.show();
        when(bufferedReader.readLine()).thenReturn("98765");
        Integer interpretationOfUserInput = menu.processInput();
        assertThat(interpretationOfUserInput, is(-1));
    }

}