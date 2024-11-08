package Command;

import Product.*;

import java.util.*;
import HeroFactory.*;

public class AddHeroCommand implements Command {
    private Scanner sc;
    private CurrentPlayerHolder currentPlayerHolder;
    private HashMap<String, HeroFactory> HeroFactory;
    private HashMap<String, String> HeroTypeHashMap;
    private String message;
    private String id;
    private String name;
    private String heroType;
    private Hero heroToAdd;
    private Stack<Command> redoStack;

    public AddHeroCommand(Scanner sc, CurrentPlayerHolder currentPlayerHolder, HashMap<String, HeroFactory> HeroFactory
                          ,Stack<Command> redoStack, String id, String name,String heroType,HashMap<String, String> HeroTypeHashMap) {
        this.sc = sc;
        this.currentPlayerHolder = currentPlayerHolder;
        this.HeroFactory = HeroFactory;
        this.redoStack = redoStack;
        this.id = id;
        this.name = name;
        this.heroType = heroType;
        this.HeroTypeHashMap =HeroTypeHashMap;
    }

    public void execute() {
        heroToAdd = HeroFactory.get(heroType).createHero(sc, id, name);
        currentPlayerHolder.getCurrentPlayer().addHero(heroToAdd);
        System.out.println("Hero is added.");
        message = "Add hero, " + heroToAdd.getHeroID() + ", " + heroToAdd.getHeroName() + ", " + HeroTypeHashMap.get(heroType);
        redoStack.clear();
    }
    public void undo() {
        currentPlayerHolder.getCurrentPlayer().removeHero(heroToAdd);
        System.out.println("Command (" + message + ") is undone.");

    }
    public void redo() {
        currentPlayerHolder.getCurrentPlayer().addHero(heroToAdd);
        System.out.println("Command (" + message + ") is redone.");
    }

    public String toString(){
        return message;
    }

}
