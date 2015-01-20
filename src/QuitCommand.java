import java.io.PrintStream;

/**
 * Created by tskolnik on 1/20/15.
 */
public class QuitCommand implements Command, Quitter {
    private PrintStream printStream;

    public QuitCommand(PrintStream printStream) {

        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("You've quit Biblioteca.");
    }


    @Override
    public String name() {
        return "Quit";
    }


    @Override
    public boolean isApplicationDone() {
        return false;
    }
}
