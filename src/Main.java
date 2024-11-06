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

        HashMap<String, HeroFactory> HeroFactory = new HashMap<>();
        HeroFactory.put("1", warriorFactory);
        HeroFactory.put("2", warlockFactory);

        Command exitCommand = new exitCommand();
        Command createPlayerCommand = new createPlayerCommand(sc,pf, currentPlayerHolder,playerVector);
        Command setCurrentPlayerCommand = new setCurrentPlayerCommand(sc,playerVector, currentPlayerHolder);
        Command DisplayAllPlayerCommand = new DisplayAllPlayerCommand(playerVector);
        Command ShowPlayerCommand = new ShowPlayerCommand(currentPlayerHolder);
        Command ChangePlayerNameCommand = new ChangePlayerNameCommand(currentPlayerHolder, sc);
        Command AddHeroCommand = new AddHeroCommand(sc, currentPlayerHolder, HeroFactory);
        Command CallHeroSkillCommand = new CallHeroSkillCommand(sc,currentPlayerHolder);
        Command DeleteHeroCommand = new DeleteHeroCommand(sc,currentPlayerHolder);

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
                    AddHeroCommand.execute();
                    break;
                case "m":
                    CallHeroSkillCommand.execute();
                    break;
                case "d":
                    DeleteHeroCommand.execute();
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
