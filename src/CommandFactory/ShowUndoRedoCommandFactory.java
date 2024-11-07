package CommandFactory;
import Command.*;
import java.util.*;

public class ShowUndoRedoCommandFactory implements CommandFactory {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;

    public ShowUndoRedoCommandFactory(Stack<Command> commandStack, Stack<Command> redoStack) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;
    }
    public Command createCommand() {
        return new ShowUndoRedoCommand(commandStack, redoStack);
    }
}
