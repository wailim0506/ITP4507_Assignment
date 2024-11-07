package Command;

import java.util.*;


public class ShowUndoRedoCommand implements Command {
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;

    public ShowUndoRedoCommand(Stack<Command> commandStack, Stack<Command> redoStack) {
        this.commandStack = commandStack;
        this.redoStack = redoStack;
    }

    public void execute() {
        System.out.println("Undo List");
        for (int i = commandStack.size() - 1; i >= 0; i--) {
            System.out.println(commandStack.get(i));
        }
        System.out.println("-- End of undo list --");
        System.out.println("Redo List");
        for (int i = redoStack.size() - 1; i >= 0; i--) {
            System.out.println(redoStack.get(i));
        }
        System.out.println("-- End of redo list --");
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
