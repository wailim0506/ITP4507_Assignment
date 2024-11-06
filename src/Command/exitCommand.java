package Command;

public class exitCommand implements Command {
    public void execute() {
        System.exit(0);
    }

    public void undo(String message) {
        //no need implementation
    }

    public void redo(String message) {
        //no need implementation
    }
}
