package Command;

import Hero.*;
import Memento.*;
import Player.*;
import java.util.*;

public class DeleteHeroCommand implements Command {
    private CurrentPlayerHolder currentPlayerHolder;
    private String message;
    private Hero heroToDelete;
    private Stack<Command> redoStack;
    private CareTaker careTaker;
    private Player playerToDelete;

    public DeleteHeroCommand(CurrentPlayerHolder currentPlayerHolder, Hero heroToDelete, Stack<Command> redoStack,
                              CareTaker careTaker){
        this.currentPlayerHolder = currentPlayerHolder;
        this.heroToDelete = heroToDelete;
        this.redoStack = redoStack;
        this.careTaker = careTaker;

    }

    public void execute(){
        System.out.println(heroToDelete.getHeroID() + " " + heroToDelete.getHeroName() + " is deleted.");
        currentPlayerHolder.getCurrentPlayer().removeHero(heroToDelete);
        message = "Delete hero, " + heroToDelete.getHeroID();
        playerToDelete = currentPlayerHolder.getCurrentPlayer();
        redoStack.clear();
        careTaker.clearRedoList();
    }

    public void undo(){
        playerToDelete.addHero(heroToDelete);
        System.out.println("Command (" + message + ") is undone.");
    }
    public void redo(){
        playerToDelete.removeHero(heroToDelete);
        System.out.println("Command (" + message + ") is redone.");
    }

    public String toString(){
        return message;
    }
}
