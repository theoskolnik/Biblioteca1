import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListBooksCommandTest {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private ListBooksCommand listBooksCommand;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        listBooksCommand = new ListBooksCommand(biblioteca, printStream);
    }

    @Test
    public void shouldCallListBooksWhenCommandIsExecuted() {
        listBooksCommand.execute();
        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldPrintListOfBooksWhenCommandIsExecuted(){
        when(biblioteca.listBooks()).thenReturn("Harry Potter");
        listBooksCommand.execute();
        verify(printStream).println("Harry Potter");
    }

    @Test
    public void shouldReturnNameOfMenuItemWhenNameMethodIsCalled() {
        String returnedName = listBooksCommand.name();
        assertThat(returnedName, is("List Books"));
    }



}