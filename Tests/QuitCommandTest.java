import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuitCommandTest {


    private QuitCommand quitCommand;

    @Before
    public void setUp() throws Exception {
        quitCommand = new QuitCommand();
    }

    @Test
    public void shouldReturnQuitWhenNameMethodIsCalled() {
        String name = quitCommand.name();
        assertThat(name, is("Quit"));
    }

}