package Command;

import Hero.*;
import Player.*;
import java.util.*;

public class ShowPlayerCommand implements Command {
    private CurrentPlayerHolder currentPlayerHolder;

    public ShowPlayerCommand(CurrentPlayerHolder currentPlayerHolder) {
        this.currentPlayerHolder = currentPlayerHolder;
    }

    public void execute() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            currentPlayerHolder.getCurrentPlayer().showPlayerDetails();
        } else {
            System.out.println("No player to show");
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
