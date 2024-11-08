package CommandFactory;

import Command.*;
import Hero.Hero;
import Player.*;

import java.util.*;

public class DeleteHeroCommandFactory implements CommandFactory {
    private Scanner sc;
    private CurrentPlayerHolder currentPlayerHolder;
    private Vector<Player> playerVector;
    private Stack<Command> commandStack;

    public DeleteHeroCommandFactory(Scanner sc, CurrentPlayerHolder currentPlayerHolder, Vector<Player> playerVector,
                                    Stack<Command> commandStack) {
        this.sc = sc;
        this.currentPlayerHolder = currentPlayerHolder;
        this.playerVector = playerVector;
        this.commandStack = commandStack;
    }

    public Command createCommand() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            if (currentPlayerHolder.getCurrentPlayer().getHeroes().size() > 0) {
                System.out.print("Please input hero ID:- ");
                String heroID = sc.nextLine();
                for (int i = 0; i < currentPlayerHolder.getCurrentPlayer().getHeroes().size(); i++) {
                    Hero hero = currentPlayerHolder.getCurrentPlayer().getHeroes().get(i);
                    if (hero.getHeroID().equals(heroID)) {
                        Command c =  new DeleteHeroCommand(currentPlayerHolder, hero);
                        commandStack.push(c);
                        return c;
                    }
                }
                //if hero not found, the following three code run, telling user what hero they have
                System.out.println("Hero not found");
                System.out.println();
                return new ShowPlayerCommand(currentPlayerHolder);

            } else {
                System.out.println("No hero available");
                //because no hero for current player, show the user they have no hero
                System.out.println();
                return new ShowPlayerCommand(currentPlayerHolder);
            }
        } else {
            System.out.println("No current player");
            //return a command with no undo/redo to avoid error
            return new DisplayAllPlayerCommand(playerVector);
        }
    }
}
