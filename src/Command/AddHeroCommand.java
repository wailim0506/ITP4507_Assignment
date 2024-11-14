package Command;

import Hero.*;
import Memento.*;
import Player.*;
import java.util.*;
import HeroFactory.*;

public class AddHeroCommand implements Command {
    private CurrentPlayerHolder currentPlayerHolder;
    private HashMap<String, HeroFactory> HeroFactory;
    private String message;
    private String id;
    private String name;
    private String heroType;
    private Hero heroToAdd;
    private Stack<Command> redoStack;
    private CareTaker careTaker;
    private Player playerToAdd; //store the player that the hero is added to, for undo and redo

    public AddHeroCommand(CurrentPlayerHolder currentPlayerHolder, HashMap<String, HeroFactory> HeroFactory
                          ,Stack<Command> redoStack, String id, String name,String heroType, CareTaker careTaker) {
        this.currentPlayerHolder = currentPlayerHolder;
        this.HeroFactory = HeroFactory;
        this.redoStack = redoStack;
        this.id = id;
        this.name = name;
        this.heroType = heroType;
        this.careTaker = careTaker;
    }

    public void execute() {
        heroToAdd = HeroFactory.get(heroType).createHero(id, name);
        currentPlayerHolder.getCurrentPlayer().addHero(heroToAdd);
        playerToAdd = currentPlayerHolder.getCurrentPlayer();
        System.out.println("Hero is added.");
        message = "Add hero, " + heroToAdd.getHeroID() + ", " + heroToAdd.getHeroName() + ", " + heroToAdd.getClass().getSimpleName();
        redoStack.clear();
        careTaker.clearRedoList();
    }
    public void undo() {
        playerToAdd.removeHero(heroToAdd);
        System.out.println("Command (" + message + ") is undone.");

    }
    public void redo() {
        playerToAdd.addHero(heroToAdd);
        System.out.println("Command (" + message + ") is redone.");
    }

    public String toString(){
        return message;
    }
}
