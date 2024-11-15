import CommandFactory.*;
import HeroFactory.*;
import Memento.*;
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

        CurrentPlayerHolder currentPlayerHolder = new CurrentPlayerHolder(null); // store current player

        HeroFactory warlockFactory = new WarlockFactory();
        HeroFactory warriorFactory = new WarriorFactory();
        UserFactory pf = new PlayerFactory();

        HashMap<String, HeroFactory> HeroFactory = new HashMap<>();
        HeroFactory.put("1", warriorFactory);
        HeroFactory.put("2", warlockFactory);

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
        commandFactories.put("a", new AddHeroCommandFactory(sc, currentPlayerHolder, HeroFactory, commandStack, redoStack, playerVector, careTaker));
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
            System.out.println();
        }
    }
}
