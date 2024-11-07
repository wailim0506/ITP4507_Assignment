package Memento;

import java.util.*;

public class CareTaker {
    Stack<Memento> undoList;  //stack to store memento to be undone
    Stack <Memento> redoList; //stack to store memento to be redone

    public void saveHero(){}
    public void savePlayer(){}
    public void undo(){}
    public void redo(){}
    public void saveRedo(){}
    public int getUndoListSize(){return 0;}
    public int getRedoListSize(){return 0;}
    public void clearRedoList(){}

}
