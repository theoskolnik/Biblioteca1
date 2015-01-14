import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testsGetBookInformation(){
        Book harryPotter = new Book("Harry Potter", "J.K. Rowling", "1997");
        Book longBook = new Book("The Book with the Longest Title!!!1!!!!", "Anon1234567890", "15");
        String harryPotterInfo = harryPotter.getInformation();
        String longBookInfo = longBook.getInformation();

        assertThat(harryPotterInfo, is("Harry Potter         | J.K. Rowli | 1997"));
        assertThat(longBookInfo,    is("The Book with the Lo | Anon123456 | 15  "));
    }

}