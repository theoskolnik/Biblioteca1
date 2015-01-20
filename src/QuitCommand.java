/**
 * Created by tskolnik on 1/20/15.
 */
public class QuitCommand implements Command, Quitter {
    @Override
    public void execute() {

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
