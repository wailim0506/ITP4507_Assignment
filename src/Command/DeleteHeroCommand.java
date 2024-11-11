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

    public DeleteHeroCommand( CurrentPlayerHolder currentPlayerHolder, Hero heroToDelete, Stack<Command> redoStack,
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
        //Maybe not need,
        redoStack.clear();
        careTaker.clearRedoList();
        //Maybe not need
    }

    public void undo(){
        //currentPlayerHolder.getCurrentPlayer().addHero(heroToDelete);
        playerToDelete.addHero(heroToDelete);
        System.out.println("Command (" + message + ") is undone.");
    }
    public void redo(){
        //currentPlayerHolder.getCurrentPlayer().removeHero(heroToDelete);
        playerToDelete.removeHero(heroToDelete);
        System.out.println("Command (" + message + ") is redone.");
    }

    public String toString(){
        return message;
    }
}
