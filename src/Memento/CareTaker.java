package Memento;
import Hero.*;
import Player.Player;

import java.util.*;

public class CareTaker {
    Stack<Memento> undoList;  //stack to store memento to be undone
    Stack <Memento> redoList; //stack to store memento to be redone

    public CareTaker(){
        undoList = new Stack<Memento>();
        redoList = new Stack<Memento>();
    }

    public void saveHero(Hero hero){
        undoList.push(new HeroMemento(hero));
    }

    public void savePlayer(Player player){
        undoList.push(new PlayerMemento(player));
    }

    public void undo(){
        undoList.pop().restore();
    }

    public void redo(){
        redoList.pop().restore();
    }

    public void saveRedoHero(Hero hero){
        redoList.push(new HeroMemento(hero));
    }

    public void saveRedoPlayer(Player player){
        redoList.push(new PlayerMemento(player));
    }

    public int getUndoListSize(){
        return undoList.size();
    }

    public int getRedoListSize(){
        return redoList.size();
    }

    public void clearRedoList(){
        redoList.clear();
    }
}
