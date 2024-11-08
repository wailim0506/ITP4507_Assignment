package Command;
import Product.*;

import java.util.*;

public class DisplayAllPlayerCommand implements Command {
    private Vector<Player> playerVector;
    public DisplayAllPlayerCommand(Vector<Player> playerVector) {
        this.playerVector = playerVector;
    }
    public void execute(){
        if (playerVector.size() > 0) {
            for (int i = 0; i < playerVector.size(); i++) {
                System.out.println("Player " + playerVector.get(i).getPlayerName() + " (" + playerVector.get(i).getPlayerID() + ")");
            }
        } else {
            System.out.println("No player to show");
        }
    }
    public void undo(){
        //no need implementation
    }
    public void redo(){
        //no need implementation
    }

    public String toString(){
        return "";
    }
}
