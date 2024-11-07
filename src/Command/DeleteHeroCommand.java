package Command;

import Hero.*;
import Player.*;
import java.util.*;

public class DeleteHeroCommand implements Command {
    private CurrentPlayerHolder currentPlayerHolder;
    private Scanner sc;
    private String message;
    private Hero heroToDelete;

    public DeleteHeroCommand( CurrentPlayerHolder currentPlayerHolder, Hero heroToDelete) {
        this.currentPlayerHolder = currentPlayerHolder;
        this.heroToDelete = heroToDelete;
    }

    public void execute(){
        System.out.println(heroToDelete.getHeroID() + " " + heroToDelete.getHeroName() + " is deleted.");
        currentPlayerHolder.getCurrentPlayer().removeHero(heroToDelete);
        message = "Delete hero, " + heroToDelete.getHeroID();
    }

    public void undo(){
        currentPlayerHolder.getCurrentPlayer().addHero(heroToDelete);
        System.out.println("Command (" + message + ") is undone.");
    }
    public void redo(){
        currentPlayerHolder.getCurrentPlayer().removeHero(heroToDelete);
        System.out.println("Command (" + message + ") is redone.");
    }

    public String toString(){
        return message;
    }
}
