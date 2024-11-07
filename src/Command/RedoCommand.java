package Command;
import java.util.*;

public class RedoCommand implements Command {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;


    public RedoCommand(Stack<Command> commandStack, Stack<Command> redoStack) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;

    }

    public void execute() {
        if(!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.redo();
            commandStack.push(command);

        }else{
            System.out.println("Nothing to redo");
        }
    }
    public void undo() {
        //no need implementation
    }
    public void redo() {
        //no need implementation
    }
    public String toString(){
        return "";
    }
}
