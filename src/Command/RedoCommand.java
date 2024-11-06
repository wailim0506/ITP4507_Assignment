package Command;
import java.util.*;

public class RedoCommand implements Command {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;
    private Stack<String> commandList;
    private Stack<String> redoList;

    public RedoCommand(Stack<Command> commandStack, Stack<Command> redoStack, Stack<String> commandList, Stack<String> redoList) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;
        this.commandList = commandList;
        this.redoList = redoList;
    }

    public void execute() {
        if(!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            String message = redoList.pop(); //pop the redo list string
            command.redo(message); //redo the command and display the message
            redoList.push(message); //add back to the redo list string
            commandStack.push(command);
            commandList.push(redoList.pop());   //pop redo list string and add to undo list string
        }else{
            System.out.println("Nothing to redo");
        }
    }
    public void undo(String message) {
        //no need implementation
    }
    public void redo(String message) {
        //no need implementation
    }
}
