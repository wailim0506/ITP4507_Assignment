package CommandFactory;
import Command.*;
import Memento.*;
import Player.*;
import Player.Player;
import PlayerFactory.*;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class CreatePlayerCommandFactory implements CommandFactory {

    private Scanner sc;
    private UserFactory pf;
    private CurrentPlayerHolder currentPlayerHolder;
    private Vector<Player> playerVector;
    private Stack<Command> redoStack;// Stack to store all commands to be redo
    private Stack<Command> commandStack;  // Stack to store executed commands
    private CareTaker careTaker;

    public CreatePlayerCommandFactory(Scanner sc, UserFactory pf, CurrentPlayerHolder currentPlayerHolder,
                                      Vector<Player> playerVector, Stack<Command> redoStack, Stack<Command> commandStack,
                                      CareTaker careTaker) {
        this.sc = sc;
        this.pf = pf;
        this.currentPlayerHolder = currentPlayerHolder;
        this.playerVector = playerVector;
        this.redoStack = redoStack;
        this.commandStack = commandStack;
        this.careTaker = careTaker;
    }

    public Command createCommand() {
        String id;
        try {
            while (true){
                System.out.print("Player ID:- ");
                id = sc.nextLine();
                if (id.equals("")) {
                    System.out.println("Player ID cannot be empty.");
                }
                else{
                    break;
                }
            }

            for (int i = 0; i < playerVector.size(); i++) {
                if (playerVector.get(i).getPlayerID().equals(id)) {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Player ID already exists");
            System.out.println("Existing player ID:- ");
            return new DisplayAllPlayerCommand(playerVector);
        }

        String name="";
        while(true){
            System.out.print("Player Name:- ");
            name = sc.nextLine();
            if(name.equals("")) {
                System.out.println("Player name cannot be empty.");
                continue;
            }else{
                break;
            }
        }

        Command c = new CreatePlayerCommand(pf, currentPlayerHolder, playerVector, redoStack,id,name,careTaker);
        commandStack.push(c);
        return c;
    }
}
