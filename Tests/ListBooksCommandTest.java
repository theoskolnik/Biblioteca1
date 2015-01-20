import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksCommandTest {

    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        biblioteca = mock(Biblioteca.class);

    }

    @Test
    public void shouldListBooksWhenCommandIsExecuted() {
        ListBooksCommand listBooksCommand = new ListBooksCommand(biblioteca);
        listBooksCommand.execute();
        verify(biblioteca).listBooks();
    }

}