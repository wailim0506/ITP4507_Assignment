package CommandFactory;
import Command.*;
import java.util.*;
public class RedoCommandFactory implements CommandFactory {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;

    public RedoCommandFactory(Stack<Command> commandStack, Stack<Command> redoStack) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;
    }


    public Command createCommand() {
        return new RedoCommand(commandStack, redoStack);
    }
}
