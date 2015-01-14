import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by tbartlett on 1/14/15.
 */
public class MainMenu {
    private BufferedReader bufferedReader;
    private final Integer invalidInput = -1;
    private final Integer listBooksInput = 1;

    public MainMenu(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public String show() {
        return "1. List Books";
    }

    public Integer processInput() throws IOException {
        String userInput = bufferedReader.readLine();

        if (userInput.compareTo("1") == 0) {
            return listBooksInput;
        } else {
            return invalidInput;
        }
    }
}
