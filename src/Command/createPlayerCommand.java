package Command;

import Player.*;
import PlayerFactory.*;
import Exception.*;

import java.util.*;

public class createPlayerCommand implements Command {
    private Scanner sc;
    private PlayerFactory pf;
    private CurrentPlayerHolder currentPlayerHolder;
    private Vector<Player> playerVector;
    private Stack<Command> redoStack; // Stack to store all commands to be redo
    private Stack<String> redoList;
    private Stack<String> commandList; // Stack to store undoable commands string
    Player p;
    String id;
    String name;

    public createPlayerCommand(Scanner sc, PlayerFactory pf, CurrentPlayerHolder currentPlayerHolder,
                               Vector<Player> playerVector, Stack<Command> redoStack, Stack<String> redoList, Stack<String> commandList,
                               String id, String name) {
        this.sc = sc;
        this.pf = pf;
        this.currentPlayerHolder = currentPlayerHolder;
        this.playerVector = playerVector;
        this.redoStack = redoStack;
        this.redoList = redoList;
        this.commandList = commandList;
        this.id = id;
        this.name = name;

    }

    public void execute() {
        p = pf.createPlayer(id,name);
        playerVector.add(this.p);
        System.out.println("Player " + p.getPlayerName() + " is created.");
        currentPlayerHolder.setCurrentPlayer(p);
        System.out.println("Current player is changed to " + p.getPlayerID());
        commandList.push("Create player " + p.getPlayerID() + ", " + p.getPlayerName());
        redoStack.clear();
        redoList.clear();
    }

    public void undo(String message) {
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

    public void redo(String message) {
        playerVector.add(this.p);
        currentPlayerHolder.setCurrentPlayer(this.p);
        System.out.println("Command (" + message + ") is redone.");
        System.out.println("Current player is changed to " + currentPlayerHolder.getCurrentPlayer().getPlayerID());
    }
}
