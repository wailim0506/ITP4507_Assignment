package Command;

import java.util.*;

public class ShowUndoRedoCommand implements Command {
    private Stack<String> commandList;
    private Stack<String> redoList;

    public ShowUndoRedoCommand(Stack<String> commandList, Stack<String> redoList) {
        this.commandList = commandList;
        this.redoList = redoList;
    }

    public void execute() {
        System.out.println("Undo List");
        for (int i = commandList.size() - 1; i >= 0; i--) {
            System.out.println(commandList.get(i));
        }
        System.out.println("-- End of undo list --");
        System.out.println("Redo List");
        for (int i = redoList.size() - 1; i >= 0; i--) {
            System.out.println(redoList.get(i));
        }
        System.out.println("-- End of redo list --");
    }
    public void undo(String message) {
    }
    public void redo(String message) {
    }
}
