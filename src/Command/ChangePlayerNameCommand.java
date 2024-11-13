package Command;
import Memento.CareTaker;
import Player.*;
import java.util.*;

public class ChangePlayerNameCommand implements Command {
    private CurrentPlayerHolder currentPlayerHolder;
    private String message;
    private String newName;
    private Stack<Command> redoStack;
    private CareTaker careTaker;

    public ChangePlayerNameCommand(CurrentPlayerHolder currentPlayerHolder, String newName, Stack<Command> redoStack, CareTaker careTaker){
        this.currentPlayerHolder = currentPlayerHolder;
        this.newName = newName;
        this.redoStack = redoStack;
        this.careTaker = careTaker;
    }

    public void execute(){
        careTaker.savePlayer(currentPlayerHolder.getCurrentPlayer());
        currentPlayerHolder.getCurrentPlayer().setPlayerName(newName);
        redoStack.clear();
        careTaker.clearRedoList();
        message = "Change player's name, " + currentPlayerHolder.getCurrentPlayer().getPlayerID() + ", " + newName;
    }
    public void undo(){
        careTaker.saveRedoPlayer(currentPlayerHolder.getCurrentPlayer());
        careTaker.undo();
        System.out.println("Command (" + message + ") is undone.");
        System.out.println("\nFantastic World (FW) \n" +
                "c = create player, g = set current player, a = add hero, m = call hero skill, d \n" +
                "= delete hero, s = show player, p = display all players, t = change player's \n" +
                "name, u = undo, r = redo, l = list undo/redo, x = exit system ");
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            System.out.println("The current player is " + currentPlayerHolder.getCurrentPlayer().getPlayerID() + " " +
                    currentPlayerHolder.getCurrentPlayer().getPlayerName());
        }
    }
    public void redo(){
        careTaker.savePlayer(currentPlayerHolder.getCurrentPlayer());
        careTaker.redo();
        System.out.println("Command (" + message + ") is redone.");
    }

    public String toString(){
        return message;
    }
}
