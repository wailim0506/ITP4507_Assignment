package CommandFactory;
import Memento.*;
import Player.*;
import Command.*;
import java.util.*;
public class ChangePlayerNameCommandFactory implements CommandFactory {
    private CurrentPlayerHolder currentPlayerHolder;
    private Scanner sc;
    private Vector<Player> playerVector;
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;
    private CareTaker careTaker;

    public ChangePlayerNameCommandFactory(CurrentPlayerHolder currentPlayerHolder, Scanner sc, Vector<Player> playerVector,
                                          Stack<Command> commandStack, Stack<Command> redoStack, CareTaker careTaker) {
        this.currentPlayerHolder = currentPlayerHolder;
        this.sc = sc;
        this.playerVector = playerVector;
        this.commandStack = commandStack;
        this.redoStack = redoStack;
        this.careTaker = careTaker;
    }

    public Command createCommand() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            System.out.print("Please input new name of the current player:- ");
            String newName = sc.nextLine();
            System.out.println("Player's name is updated.");
            Command c = new ChangePlayerNameCommand(currentPlayerHolder, newName, redoStack, careTaker);
            commandStack.push(c);
            return c;
        }else{
            System.out.println("No player to change name");
            //return a command with no undo/redo to avoid error
            return new DisplayAllPlayerCommand(playerVector);
        }
    }
}
