package Command;

import Player.*;
import PlayerFactory.*;

import java.util.*;

public class CreatePlayerCommand implements Command {
    private Scanner sc;
    private PlayerFactory pf;
    private CurrentPlayerHolder currentPlayerHolder;
    private Vector<Player> playerVector;
    private Stack<Command> redoStack; // Stack to store all commands to be redo
    private Player p;
    private String id;
    private String name;
    private String message;

    public CreatePlayerCommand(Scanner sc, PlayerFactory pf, CurrentPlayerHolder currentPlayerHolder,
                               Vector<Player> playerVector, Stack<Command> redoStack,
                               String id, String name) {
        this.sc = sc;
        this.pf = pf;
        this.currentPlayerHolder = currentPlayerHolder;
        this.playerVector = playerVector;
        this.redoStack = redoStack;
        this.id = id;
        this.name = name;

    }

    public void execute() {
        p = pf.createPlayer(id,name);
        playerVector.add(this.p);
        System.out.println("Player " + p.getPlayerName() + " is created.");
        currentPlayerHolder.setCurrentPlayer(p);
        System.out.println("Current player is changed to " + p.getPlayerID());
        message = "Create player, " + p.getPlayerID() + ", " + p.getPlayerName();
        redoStack.clear();
    }

    public void undo() {
        playerVector.remove(this.p);
        System.out.println("Command (" + message + ") is undone.");
        if (!playerVector.isEmpty()) {
            currentPlayerHolder.setCurrentPlayer(playerVector.get(0));
            System.out.println("Current player is changed to " + currentPlayerHolder.getCurrentPlayer().getPlayerID());
        } else {
            currentPlayerHolder.setCurrentPlayer(null);
            System.out.println("No current player now");
        }
    }

    public void redo() {
        playerVector.add(this.p);
        currentPlayerHolder.setCurrentPlayer(this.p);
        System.out.println("Command (" + message + ") is redone.");
        System.out.println("The current player is changed to " + currentPlayerHolder.getCurrentPlayer().getPlayerID() + ".");
    }

    public String toString(){
        return message;
    }
}
