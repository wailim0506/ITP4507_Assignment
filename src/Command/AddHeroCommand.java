package Command;

import Hero.*;
import Player.*;
import java.util.*;
import HeroFactory.*;

public class AddHeroCommand implements Command {
    private Scanner sc;
    private CurrentPlayerHolder currentPlayerHolder;
    private HashMap<String, HeroFactory> HeroFactory;
    private String message;

    public AddHeroCommand(Scanner sc, CurrentPlayerHolder currentPlayerHolder, HashMap<String, HeroFactory> HeroFactory) {
        this.sc = sc;
        this.currentPlayerHolder = currentPlayerHolder;
        this.HeroFactory = HeroFactory;
    }

    public void execute() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            String id;
            String name;
            try{
                System.out.print("Please input hero information (id, name):- ");
                String idName = sc.nextLine();
                String[] split = idName.split(", ");
                id = split[0];
                name = split[1];
            }catch (Exception e){
                System.out.println("Invalid input");
                return;
            }
            System.out.print("Hero Type (1 = Warrior | 2 = Warlock ):- ");
            String heroType = sc.nextLine();
            Hero heroToAdd;
            try{
                heroToAdd = HeroFactory.get(heroType).createHero(sc, id, name);
                currentPlayerHolder.getCurrentPlayer().addHero(heroToAdd);
                System.out.println("Hero is added.");
            }catch (Exception e){
                System.out.println("Invalid hero type");
            }
        }else{
            System.out.println("No player to add hero");
        }

    }
    public void undo() {
    }
    public void redo() {
    }

    public String toString(){
        return message;
    }

}
