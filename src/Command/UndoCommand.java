package Command;
import java.util.*;

public class UndoCommand implements Command {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;


    public UndoCommand(Stack<Command> commandStack, Stack<Command> redoStack) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;

    }

    public void execute() {
        if(!commandStack.isEmpty()){
            Command command = commandStack.pop();
            command.undo();
            redoStack.push(command);
        }else{
            System.out.println("Nothing to undo");
        }
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
