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
            String message = commandList.pop(); //pop the undo list string
            command.undo(message);  //undo the command and display the message
            commandList.push(message); //add back to the undo list string
            redoStack.push(command);
            redoList.push(commandList.pop()); //pop undo list string and add to redo list string
        }else{
            System.out.println("Nothing to undo");
        }
    }
    public void undo(String message) {
    }
    public void redo(String message) {
    }
}
