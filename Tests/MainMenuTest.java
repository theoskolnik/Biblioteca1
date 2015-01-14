import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MainMenuTest {

    private MainMenu menu;

    @Before
    public void SetUp(){
        menu = new MainMenu();
    }
    @Test
    public void shouldDisplayMenuWhenCalled(){
        String menuString = menu.show();
        assertThat(menuString, is("1. List Books"));
    }

}