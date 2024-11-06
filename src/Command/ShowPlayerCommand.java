package Command;

import Hero.*;
import Player.*;

import java.util.*;

public class ShowPlayerCommand implements Command {
    private Vector<Player> playerVector;
    private CurrentPlayerHolder currentPlayerHolder;

    public ShowPlayerCommand(Vector<Player> playerVector, CurrentPlayerHolder currentPlayerHolder) {
        this.playerVector = playerVector;
        this.currentPlayerHolder = currentPlayerHolder;
    }

    public void execute() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            System.out.println("Player " + currentPlayerHolder.getCurrentPlayer().getPlayerName() + " (" + currentPlayerHolder.getCurrentPlayer().getPlayerID() + ")");
            System.out.println("Heroes: ");
            Vector<Hero> playerHeroVector = currentPlayerHolder.getCurrentPlayer().getHeroes();
            if (playerHeroVector.size() > 0) {
                for (int i = 0; i < playerHeroVector.size(); i++) {
                    playerHeroVector.get(i).showHeroStatus();
                }
            } else {
                System.out.println("No hero to show");
            }
        } else {
            System.out.println("No player to show");
        }
    }

    public void undo() {
    }

    public void redo() {
    }
}
