package Command;

public class ExitCommand implements Command {
    public void execute() {
        System.exit(0);
    }

    public void undo() {
        //no need implementation
    }

    public void redo() {
        //no need implementation
    }

    public String getMessage(){
        return "";
    }
}
