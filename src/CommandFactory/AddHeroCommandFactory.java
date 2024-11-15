package CommandFactory;

import Command.*;
import Memento.*;
import Player.*;
import HeroFactory.*;
import Hero.*;

import java.util.*;

public class AddHeroCommandFactory implements CommandFactory {
    private Scanner sc;
    private CurrentPlayerHolder currentPlayerHolder;
    private String id;
    private String name;
    private HashMap<String, HeroFactory> HeroFactory;
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;
    private Vector<Player> playerVector;
    private CareTaker careTaker;

    public AddHeroCommandFactory(Scanner sc, CurrentPlayerHolder currentPlayerHolder, HashMap<String, HeroFactory> HeroFactory,
                                  Stack<Command> commandStack, Stack<Command> redoStack,
                                 Vector<Player> playerVector, CareTaker careTaker) {
        this.sc = sc;
        this.currentPlayerHolder = currentPlayerHolder;
        this.HeroFactory = HeroFactory;
        this.commandStack = commandStack;
        this.redoStack = redoStack;
        this.playerVector = playerVector;
        this.careTaker = careTaker;
    }

    public Command createCommand() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            //check hero id and name input below, if invalid, ask again until correct, avoid creating command with wrong input
            while (true) {
                try {
                    System.out.print("Please input hero information (id, name):- ");
                    String idName = sc.nextLine();
                    String[] split = idName.split(", ");
                    id = split[0];
                    name = split[1];
                    //check existing hero id for current player
                    boolean sameHeroID = false;
                    for (Hero h : currentPlayerHolder.getCurrentPlayer().getHeroes()) {
                        if (h.getHeroID().equals(id)) {
                            System.out.println("Hero ID already exist");
                            sameHeroID = true;
                            break;
                        }
                    }
                    if (sameHeroID){
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            }

            //check hero type input below, if invalid, ask again until correct, avoid creating command with wrong input
            while (true) {
                System.out.print("Hero Type (1 = Warrior | 2 = Warlock ):- ");
                String heroType = sc.nextLine();
                if (HeroFactory.get(heroType) != null) {
                    Command c = new AddHeroCommand(currentPlayerHolder, HeroFactory, redoStack, id, name, heroType,careTaker);
                    commandStack.push(c);
                    return c;
                } else {
                    System.out.println("Invalid hero type");
                }
            }
        } else {
            System.out.println("No player to add hero");
            //return a command with no undo/redo to avoid error
            return new DisplayAllPlayerCommand(playerVector);
        }
    }
}
