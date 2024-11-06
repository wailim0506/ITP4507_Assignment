package Command;

public interface Command {
    public void execute();
    public void undo(String message);
    public void redo(String message);
}
