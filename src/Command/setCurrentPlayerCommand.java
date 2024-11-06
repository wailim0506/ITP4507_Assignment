package Command;

import Player.*;

import java.util.*;

public class setCurrentPlayerCommand implements Command{
    private Vector<Player> playerVector;
    private Scanner sc;
    private CurrentPlayerHolder currentPlayerHolder;

    public setCurrentPlayerCommand( Scanner sc,Vector<Player> playerVector, CurrentPlayerHolder currentPlayerHolder) {
        this.playerVector = playerVector;
        this.sc = sc;
        this.currentPlayerHolder = currentPlayerHolder;
    }

    public void execute(){
        if (playerVector.size() > 0) {
            System.out.print("Please input player ID:- ");
            String id = sc.nextLine();
            for (int i = 0; i < playerVector.size(); i++) {
                if (playerVector.get(i).getPlayerID().equals(id)) {
                    currentPlayerHolder.setCurrentPlayer(playerVector.get(i));
                    System.out.println("Changed current player to " + currentPlayerHolder.getCurrentPlayer().getPlayerID());
                    break;
                }

                if (i == playerVector.size() - 1) {
                    System.out.println("Player not found");
                }
            }
        } else {
            System.out.println("No player available");
        }
    }

    public void undo(){

    }

    public void redo(){

    }
}
