package Command;
import Player.*;
import java.util.*;

public class ChangePlayerNameCommand implements Command {
    private CurrentPlayerHolder currentPlayerHolder;
    private Scanner sc;
    private String message;

    public ChangePlayerNameCommand(CurrentPlayerHolder currentPlayerHolder, Scanner sc) {
        this.currentPlayerHolder = currentPlayerHolder;
        this.sc = sc;
    }

    public void execute(){
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            System.out.print("Please input new name of the current player:- ");
            String newName = sc.nextLine();
            currentPlayerHolder.getCurrentPlayer().setPlayerName(newName);
            System.out.println("Player's name is updated.");
        }else{
            System.out.println("No player to change name");
        }
    }
    public void undo(){
        //use caretaker undo()
    }
    public void redo(){
        //use caretaker redo()
    }

    public String toString(){
        return message;
    }
}
