package CommandFactory;
import Command.*;
import java.util.*;

public class UndoCommandFactory implements CommandFactory {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;

    public UndoCommandFactory(Stack<Command> commandStack, Stack<Command> redoStack) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;
    }

    public Command createCommand() {
        return new UndoCommand(commandStack, redoStack);
    }
}
