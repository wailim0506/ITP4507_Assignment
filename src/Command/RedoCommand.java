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
            command.redo();
            commandStack.push(command);
            commandList.push(redoList.pop());
        }else{
            System.out.println("Nothing to redo");
        }
    }
    public void undo() {
    }
    public void redo() {
    }
}
