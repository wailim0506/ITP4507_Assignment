package PlayerFactory;

import Player.*;

import java.util.*;

public class PlayerFactory {
    public Player createPlayer(Scanner sc){
        System.out.print("Player ID:- ");
        String id = sc.nextLine();
        System.out.print("Player Name:- ");
        String name = sc.nextLine();
        return new Player(id,name);
    }
}
