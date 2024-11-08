package Command;

import Hero.*;
import Memento.*;
import Player.*;
import java.util.*;

public class CallHeroSkillCommand implements Command {
    private String message;
    private Hero hero;
    private Stack<Command> redoStack;
    private CareTaker careTaker;

    public CallHeroSkillCommand(Hero hero, Stack<Command> redoStack, CareTaker careTaker){
        this.hero = hero;
        this.redoStack = redoStack;
        this.careTaker = careTaker;
    }

    public void execute(){
        careTaker.saveHero(hero);
        hero.callSkill();
        System.out.println(hero.getHeroID() + " " + hero.getHeroName() + "'s attributes are changed to:");
        hero.showHeroStatus();
        redoStack.clear();
        careTaker.clearRedoList();

        if(hero instanceof Warlock){
            message = "Call hero skill, " + hero.getHeroID() + ", " + hero.getHeroName() + ", Warlock, Hp: "+hero.getHp() + ", " +
                    "Damage: "+hero.getDamage() + ", Mp: "+((Warlock) hero).getMp();
        }else if(hero instanceof Warrior){
            message = "Call hero skill, " + hero.getHeroID() + ", " + hero.getHeroName() + ", Warrior, Hp: "+hero.getHp() + ", " +
                    "Damage: "+hero.getDamage() + ", Defence Point: "+((Warrior) hero).getDefencePoint();
        }
    }
    public void undo(){
        careTaker.saveRedoHero(hero);
        careTaker.undo();
        System.out.println("Command (" + message + ") is undone.");
    }
    public void redo(){
        careTaker.saveHero(hero);
        careTaker.redo();
        System.out.println("Command (" + message + ") is redone.");
    }

    public String toString(){
        return message;
    }
}
