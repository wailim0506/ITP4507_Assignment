import HeroFactory.*;
import Hero.*;
import PlayerFactory.*;
import Command.*;
import Player.*;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Vector<Player> playerVector = new Vector<Player>(); // Vector to store all players
        Stack<Command> commandStack = new Stack<Command>(); // Stack to store executed commands
        Stack<Command> redoStack = new Stack<Command>(); // Stack to store all commands to be redo

        CurrentPlayerHolder currentPlayerHolder = new CurrentPlayerHolder(null); // Current player

        HeroFactory warlockFactory = new WarlockFactory();
        HeroFactory warriorFactory = new WarriorFactory();
        PlayerFactory pf = new PlayerFactory();

        Command exitCommand = new exitCommand();
        Command createPlayerCommand = new createPlayerCommand(sc,pf, currentPlayerHolder,playerVector);
        Command setCurrentPlayerCommand = new setCurrentPlayerCommand(sc,playerVector, currentPlayerHolder);
        Command DisplayAllPlayerCommand = new DisplayAllPlayerCommand(playerVector);
        Command ShowPlayerCommand = new ShowPlayerCommand(playerVector, currentPlayerHolder);
        Command ChangePlayerNameCommand = new ChangePlayerNameCommand(currentPlayerHolder, sc);

        while (true) {
            System.out.println("Fantastic World (FW) \n" +
                    "c = create player, g = set current player, a = add hero, m = call hero skill, d \n" +
                    "= delete hero, s = show player, p = display all players, t = change player's \n" +
                    "name, u = undo, r = redo, l = list undo/redo, x = exit system ");
            if (currentPlayerHolder.getCurrentPlayer() != null) {
                System.out.println("The current player is " + currentPlayerHolder.getCurrentPlayer().getPlayerID() + " " +
                        currentPlayerHolder.getCurrentPlayer().getPlayerName());
            }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            String input = sc.nextLine();
            switch (input) {
                case "c":
                    createPlayerCommand.execute();
                    break;
                case "g":
                    setCurrentPlayerCommand.execute();
                    break;
                case "a":
                    if (currentPlayerHolder.getCurrentPlayer() == null) {
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
                        currentPlayerHolder.getCurrentPlayer().addHero(heroToAdd);
                        System.out.println("Hero is added.");
                    } else if (heroType.equals("2")) {
                        heroToAdd = warlockFactory.createHero(sc, id, name);
                        currentPlayerHolder.getCurrentPlayer().addHero(heroToAdd);
                        System.out.println("Hero is added.");
                    } else {
                        System.out.println("Invalid hero type");
                    }
                    break;
                case "m":
                    if (playerVector.size() > 0) {
                        if (currentPlayerHolder.getCurrentPlayer().getHeroes().size() > 0) {
                            System.out.print("Please input hero ID:- ");
                            String heroID = sc.nextLine();
                            boolean found = false;
                            for (int i = 0; i < currentPlayerHolder.getCurrentPlayer().getHeroes().size(); i++) {
                                Hero hero = currentPlayerHolder.getCurrentPlayer().getHeroes().get(i);
                                if (hero.getHeroID().equals(heroID)) {
                                    found = true;
                                    hero.callSkill();
                                    System.out.println(hero.getHeroID() + " " + hero.getHeroName() + "'s attributes are changed to:");
                                    hero.showHeroStatus();
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Hero not found");
                            }
                        }else{
                            System.out.println("No hero available");
                        }
                    }else{
                        System.out.println("No player to call hero skills");
                    }
                    break;
                case "d":
                    if (currentPlayerHolder.getCurrentPlayer() != null){
                        if (currentPlayerHolder.getCurrentPlayer().getHeroes().size() > 0) {
                            System.out.print("Please input hero ID:- ");
                            String heroID = sc.nextLine();
                            boolean found = false;
                            for (int i = 0; i < currentPlayerHolder.getCurrentPlayer().getHeroes().size(); i++) {
                                Hero hero = currentPlayerHolder.getCurrentPlayer().getHeroes().get(i);
                                if (hero.getHeroID().equals(heroID)) {
                                    found = true;
                                    System.out.println(hero.getHeroID() + " " + hero.getHeroName() + "is deleted.");
                                    currentPlayerHolder.getCurrentPlayer().getHeroes().remove(i);
                                }
                            }
                            if (!found) {
                                System.out.println("Hero not found");
                            }
                        }else{
                            System.out.println("No hero available");
                        }
                    }else{
                        System.out.println("No current player");
                    }
                    break;
                case "s":
                    ShowPlayerCommand.execute();
                    break;
                case "p":
                    DisplayAllPlayerCommand.execute();
                    break;
                case "t":
                    ChangePlayerNameCommand.execute();
                    break;
                case "u":
                    break;
                case "r":
                    break;
                case "l":
                    break;
                case "x":
                    exitCommand.execute();
                default:
                    System.out.println("Invalid command");

            }
            System.out.println();
        }
    }
}
