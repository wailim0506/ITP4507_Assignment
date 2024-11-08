import CommandFactory.CommandFactory;
import HeroFactory.*;
import Memento.*;
import PlayerFactory.*;
import Command.*;
import Player.*;
import CommandFactory.*;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Vector<Player> playerVector = new Vector<Player>(); // Vector to store all players
        Stack<Command> commandStack = new Stack<Command>(); // Stack to store executed commands
        Stack<Command> redoStack = new Stack<Command>(); // Stack to store all commands to be redo

        CurrentPlayerHolder currentPlayerHolder = new CurrentPlayerHolder(null); // store current player

        HeroFactory warlockFactory = new WarlockFactory();
        HeroFactory warriorFactory = new WarriorFactory();
        PlayerFactory pf = new PlayerFactory();

        HashMap<String, String> HeroType = new HashMap<>(); //for add hero command toString to print hero type base on user input
        HeroType.put("1", "Warrior");
        HeroType.put("2", "Warlock");

        HashMap<String, HeroFactory> HeroFactory = new HashMap<>();
        HeroFactory.put("1", warriorFactory);
        HeroFactory.put("2", warlockFactory);

//        HashMap<String, String> HeroTypeHashMap = new HashMap<>();  //use in add hero command
//        HeroTypeHashMap.put("H001", HeroType.get("1"));

        CareTaker careTaker = new CareTaker();

        HashMap<String, CommandFactory> commandFactories = new HashMap<>();
        commandFactories.put("c", new CreatePlayerCommandFactory(sc, pf, currentPlayerHolder, playerVector, redoStack, commandStack, careTaker));
        commandFactories.put("x", new ExitCommandFactory());
        commandFactories.put("u", new UndoCommandFactory(commandStack, redoStack));
        commandFactories.put("r", new RedoCommandFactory(commandStack, redoStack));
        commandFactories.put("l", new ShowUndoRedoCommandFactory(commandStack, redoStack));
        commandFactories.put("s", new ShowPlayerCommandFactory(currentPlayerHolder));
        commandFactories.put("p", new DisplayAllPlayerCommandFactory(playerVector));
        commandFactories.put("g", new SetCurrentPlayerCommandFactory(sc, playerVector, currentPlayerHolder));
        commandFactories.put("a", new AddHeroCommandFactory(sc, currentPlayerHolder, HeroFactory, HeroType, commandStack, redoStack, playerVector, careTaker));
        commandFactories.put("d", new DeleteHeroCommandFactory(sc, currentPlayerHolder, playerVector, commandStack, redoStack, careTaker));
        commandFactories.put("m", new CallHeroSkillCommandFactory(currentPlayerHolder, sc, commandStack, redoStack, playerVector, careTaker));
        commandFactories.put("t", new ChangePlayerNameCommandFactory(currentPlayerHolder, sc, playerVector, commandStack, redoStack, careTaker));


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
            try{
                String input = sc.nextLine();
                commandFactories.get(input).createCommand().execute();
            }catch (Exception e){
                System.out.println("Invalid command");
            }

//            switch (input) {
//                case "c":
//                    createPlayerCommandFactory.createCommand().execute();
//                    break;
//                case "g":
//                    SetCurrentPlayerCommandFactory.createCommand().execute();
//                    break;
//                case "a":
//                    AddHeroCommandFactory.createCommand().execute();
//                    break;
//                case "m":
//                    CallHeroSkillCommandFactory.createCommand().execute();
//                    break;
//                case "d":
//                    DeleteHeroCommandFactory.createCommand().execute();
//                    break;
//                case "s":
//                    ShowPlayerCommandFactory.createCommand().execute();
//                    break;
//                case "p":
//                    DisplayAllPlayerCommandFactory.createCommand().execute();
//                    break;
//                case "t":
//                    ChangePlayerNameCommandFactory.createCommand().execute();
//                    break;
//                case "u":
//                    undoCommandFactory.createCommand().execute();
//                    break;
//                case "r":
//                    redoCommandFactory.createCommand().execute();
//                    break;
//                case "l":
//                    ShowUndoRedoCommandFactory.createCommand().execute();
//                    break;
//                case "x":
//                    exitCommandFactory.createCommand().execute();
//                default:
//                    System.out.println("Invalid command");
//            }
            System.out.println();
        }
    }
}
