import HeroFactory.*;
import Hero.*;
import PlayerFactory.*;
import Command.*;
import Player.*;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        HeroFactory warlockFactory = new WarlockFactory();
        HeroFactory warriorFactory = new WarriorFactory();
        PlayerFactory pf = new PlayerFactory();

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
                    if (playerVector.size() > 0) {
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
                    } else {
                        System.out.println("No player available");
                    }
                    break;
                case "a":
                    if (currentPlayer == null) {
                        System.out.println("No player to add hero");
                        break;
                    }
                    System.out.print("Please input hero information (id, name):- ");
                    String idName = sc.nextLine();
                    String[] split = idName.split(", ");
                    String id = split[0];
                    String name = split[1];
                    System.out.print("Hero Type (1 = Warrior | 2 = Warlock ):- ");
                    String heroType = sc.nextLine();
                    Hero heroToAdd;
                    if (heroType.equals("1")) {
                        heroToAdd = warriorFactory.createHero(sc, id, name);
                        currentPlayer.addHero(heroToAdd);
                        System.out.println("Hero is added.");
                    } else if (heroType.equals("2")) {
                        heroToAdd = warlockFactory.createHero(sc, id, name);
                        currentPlayer.addHero(heroToAdd);
                        System.out.println("Hero is added.");
                    } else {
                        System.out.println("Invalid hero type");
                    }
                    break;
                case "m":
                    break;
                case "d":
                    break;
                case "s":
                    if (currentPlayer != null) {
                        System.out.println("Player " + currentPlayer.getPlayerName() + " (" + currentPlayer.getPlayerID() + ")");
                        System.out.println("Heroes: ");
                        Vector<Hero> playerHeroVector = currentPlayer.getHeroes();
                        if (playerVector.size() > 0) {
                            for (int i = 0; i < playerHeroVector.size(); i++) {
                             // to be done
                            }
                        } else {
                            System.out.println("No hero to show");
                        }
                        // to be done
                    } else {
                        System.out.println("No player to show");
                    }
                    break;
                case "p":
                    if (playerVector.size() > 0) {
                        for (int i = 0; i < playerVector.size(); i++) {
                            System.out.println("Player " + playerVector.get(i).getPlayerName() + " (" + playerVector.get(i).getPlayerID() + ")");
                        }
                    } else {
                        System.out.println("No player to show");
                    }
                    break;
                case "t":
                    if (currentPlayer == null) {
                        System.out.println("No player to change name");
                        break;
                    }
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
