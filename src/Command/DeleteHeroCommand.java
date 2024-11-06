package Command;

import Hero.*;
import Player.*;
import java.util.*;

public class DeleteHeroCommand implements Command {
    private CurrentPlayerHolder currentPlayerHolder;
    private Scanner sc;

    public DeleteHeroCommand(Scanner sc, CurrentPlayerHolder currentPlayerHolder){
        this.currentPlayerHolder = currentPlayerHolder;
        this.sc = sc;
    }

    public void execute(){
        if (currentPlayerHolder.getCurrentPlayer() != null){
            if (currentPlayerHolder.getCurrentPlayer().getHeroes().size() > 0) {
                System.out.print("Please input hero ID:- ");
                String heroID = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < currentPlayerHolder.getCurrentPlayer().getHeroes().size(); i++) {
                    Hero hero = currentPlayerHolder.getCurrentPlayer().getHeroes().get(i);
                    if (hero.getHeroID().equals(heroID)) {
                        found = true;
                        System.out.println(hero.getHeroID() + " " + hero.getHeroName() + " is deleted.");
                        currentPlayerHolder.getCurrentPlayer().getHeroes().remove(i);
                    }
                }
                if (!found) {
                    System.out.println("Hero not found");
                }
            }else{
                System.out.println("No hero available");
            }
        }else{
            System.out.println("No current player");
        }
    }
    public void undo(){
    }
    public void redo(){
    }
}
