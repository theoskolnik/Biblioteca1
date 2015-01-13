import java.io.PrintStream;

/**
 * Created by tbartlett on 1/13/15.
 */
public class Biblioteca {

    String[] books = new String[]{};
    PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printStream.println("Welcome to Biblioteca");
        listBooks();
    }

    public void listBooks() {
        //List books
        /*printStream.println("\nBooks");
        for(String book:books){
            printStream.println(book);
        }*/
    }


}
