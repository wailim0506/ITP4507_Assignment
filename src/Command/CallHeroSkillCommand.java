package Command;

import Hero.*;
import Player.*;
import java.util.*;

public class CallHeroSkillCommand implements Command {
    private Scanner sc;
    private CurrentPlayerHolder currentPlayerHolder;

    public CallHeroSkillCommand(Scanner sc, CurrentPlayerHolder currentPlayerHolder) {
        this.sc = sc;
        this.currentPlayerHolder = currentPlayerHolder;
    }

    public void execute(){
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            if (currentPlayerHolder.getCurrentPlayer().getHeroes().size() > 0) {
                System.out.print("Please input hero ID:- ");
                String heroID = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < currentPlayerHolder.getCurrentPlayer().getHeroes().size(); i++) {
                    Hero hero = currentPlayerHolder.getCurrentPlayer().getHeroes().get(i);
                    if (hero.getHeroID().equals(heroID)) {
                        found = true;
                        hero.callSkill();
                        System.out.println(hero.getHeroID() + " " + hero.getHeroName() + "'s attributes are changed to:");
                        hero.showHeroStatus();
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Hero not found");
                }
            }else{
                System.out.println("No hero available");
            }
        }else{
            System.out.println("No player to call hero skills");
        }
    }
    public void undo(String message){

    }
    public void redo(String message){

    }
}
