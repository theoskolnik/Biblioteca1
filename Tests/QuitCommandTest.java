import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {


    private QuitCommand quitCommand;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        quitCommand = new QuitCommand(printStream);
    }

    @Test
    public void shouldReturnQuitWhenNameMethodIsCalled() {
        String name = quitCommand.name();
        assertThat(name, is("Quit"));
    }

    @Test
    public void shouldPrintQuitMessageWhenExecuteIsCalled(){
        quitCommand.execute();
        verify(printStream).println("You've quit Biblioteca.");
    }



}