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

    public createPlayerCommand(Scanner sc, PlayerFactory pf, CurrentPlayerHolder currentPlayerHolder, Vector<Player> playerVector) {
        this.sc = sc;
        this.pf = pf;
        this.currentPlayerHolder = currentPlayerHolder;
        this.playerVector = playerVector;
    }

    public void execute(){
        try{
            Player p = pf.createPlayer(sc,playerVector);
            playerVector.add(p);
            System.out.println("Player " + p.getPlayerName() + " is created.");
            currentPlayerHolder.setCurrentPlayer(p);
            System.out.println("Current player is changed to " + p.getPlayerID());
        }catch (PlayerIDExistException e){
            System.out.println(e.getMessage());
        }
    }
    public void undo(){

    }
    public void redo(){

    }
}
