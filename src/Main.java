import HeroFactory.*;
import Hero.*;
import PlayerFactory.*;
import Command.*;
import Player.*;

import javax.sound.midi.SysexMessage;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        HeroFactory n = new WarlockFactory();
        PlayerFactory pf = new PlayerFactory();
//        Player u = p.createPlayer(sc);
//        Hero y = n.createHero(sc);
        Vector<Player> playerVector = new Vector<Player>(); // Vector to store all players
        Stack<Command> commandStack = new Stack<Command>(); // Stack to store executed commands
        Stack<Command> redoStack = new Stack<Command>(); // Stack to store all commands to be redo

        Player currentPlayer = null;

        while (true) {
            System.out.println("Fantastic World (FW) \n" +
                    "c = create player, g = set current player, a = add hero, m = call hero skill, d \n" +
                    "= delete hero, s = show player, p = display all players, t = change player's \n" +
                    "name, u = undo, r = redo, l = list undo/redo, x = exit system ");
            if (currentPlayer != null) {
                System.out.println("The current player is " + currentPlayer.getPlayerID() + " " +
                        currentPlayer.getPlayerName());
            }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            String input = sc.nextLine();
            switch (input) {
                case "c":
                    Player p = pf.createPlayer(sc);
                    playerVector.add(p);
                    System.out.println("Player " + p.getPlayerName() + " is created.");
                    //System.out.println("Number of player in vector: " + playerVector.size());
                    currentPlayer = p;
                    System.out.println("Current player is changed to " + p.getPlayerID());
                    break;
                case "g":
                    if (playerVector.size() > 0){
                        System.out.print("Please input player ID:- ");
                        String id = sc.nextLine();
                        for (int i = 0; i < playerVector.size(); i++) {
                            if (playerVector.get(i).getPlayerID().equals(id)) {
                                currentPlayer = playerVector.get(i);
                                System.out.println("Changed current player to " + currentPlayer.getPlayerID());
                                break;
                            }

                            if (i == playerVector.size() - 1) {
                                System.out.println("Player not found");
                            }
                        }
                    }else{
                        System.out.println("No player available");
                    }
                    break;
                case "a":
                    break;
                case "m":
                    break;
                case "d":
                    break;
                case "s":
                    if (currentPlayer != null){
                        System.out.println("Player " + currentPlayer.getPlayerName() + " (" + currentPlayer.getPlayerID() + ")");
                        System.out.println("Heroes: ");
                        //to be done
                    }else{
                        System.out.println("No player to show");
                    }
                    break;
                case "p":
                    break;
                case "t":
                    System.out.print("Please input new name of the current player:- ");
                    String newName = sc.nextLine();
                    currentPlayer.setPlayerName(newName);
                    System.out.println("Player's name is updated.");
                    break;
                case "u":
                    break;
                case "r":
                    break;
                case "l":
                    break;
                case "x":
                    System.exit(0);
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
