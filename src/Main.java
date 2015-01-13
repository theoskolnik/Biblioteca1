import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ArrayList<String> books = new ArrayList<String>();
        new Biblioteca(books, printStream).start();

    }
}
