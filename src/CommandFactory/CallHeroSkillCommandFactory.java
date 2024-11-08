package CommandFactory;
import Command.*;
import Hero.*;
import Player.*;
import Memento.*;
import java.util.*;

public class CallHeroSkillCommandFactory implements CommandFactory {
    private CurrentPlayerHolder currentPlayerHolder;
    private Scanner sc;
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;
    private Vector<Player> playerVector;
    private CareTaker careTaker;

    public CallHeroSkillCommandFactory(CurrentPlayerHolder currentPlayerHolder, Scanner sc,
                                       Stack<Command> commandStack, Stack<Command> redoStack,
                                       Vector<Player> playerVector, CareTaker careTaker) {
        this.currentPlayerHolder = currentPlayerHolder;
        this.sc = sc;
        this.commandStack = commandStack;
        this.redoStack = redoStack;
        this.playerVector = playerVector;
        this.careTaker = careTaker;
    }

    public Command createCommand() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            if (currentPlayerHolder.getCurrentPlayer().getHeroes().size() > 0) {
                System.out.print("Please input hero ID:- ");
                String heroID = sc.nextLine();
                for (int i = 0; i < currentPlayerHolder.getCurrentPlayer().getHeroes().size(); i++) {
                    Hero hero = currentPlayerHolder.getCurrentPlayer().getHeroes().get(i);
                    if (hero.getHeroID().equals(heroID)) {
                        Command c =  new CallHeroSkillCommand(hero,redoStack,careTaker);
                        commandStack.push(c);
                        return c;
                    }
                }
                //if hero not found, the following three code run, telling user what hero they have
                System.out.println("Hero not found");
                System.out.println();
                return new ShowPlayerCommand(currentPlayerHolder);

            }else{
                System.out.println("No hero available");
                //because no hero for current player, show the user they have no hero
                System.out.println();
                return new ShowPlayerCommand(currentPlayerHolder);
            }
        }else{
            System.out.println("No player to call hero skills");
            //return a command with no undo/redo to avoid error
            return new DisplayAllPlayerCommand(playerVector);
        }
    }
}
