package PlayerFactory;

import Player.*;
import Exception.*;
import java.util.*;

public class PlayerFactory {
    public Player createPlayer(Scanner sc, Vector<Player> playerVector) throws PlayerIDExistException{
        System.out.print("Player ID:- ");
        String id = sc.nextLine();
        for (int i = 0; i < playerVector.size(); i++){
            if (playerVector.get(i).getPlayerID().equals(id)){
                throw new PlayerIDExistException();
            }
        }
        System.out.print("Player Name:- ");
        String name = sc.nextLine();
        return new Player(id,name);
    }
}
