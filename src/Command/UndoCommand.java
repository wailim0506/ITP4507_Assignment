package Command;
import java.util.*;
public class UndoCommand implements Command {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;
    private Stack<String> commandList;
    private Stack<String> redoList;

    public UndoCommand(Stack<Command> commandStack, Stack<Command> redoStack, Stack<String> commandList, Stack<String> redoList) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;
        this.commandList = commandList;
        this.redoList = redoList;
    }

    public void execute() {
        if(!commandStack.isEmpty()){
            Command command = commandStack.pop();
            command.undo();
            redoStack.push(command);
            redoList.push(commandList.pop());
        }else{
            System.out.println("Nothing to undo");
        }
    }
    public void undo() {
    }
    public void redo() {
    }
}
