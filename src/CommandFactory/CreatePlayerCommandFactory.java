package CommandFactory;
import Command.*;
import Memento.*;
import Player.CurrentPlayerHolder;
import Player.Player;
import PlayerFactory.PlayerFactory;
import Exception.*;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class CreatePlayerCommandFactory implements CommandFactory {

    private Scanner sc;
    private PlayerFactory pf;
    private CurrentPlayerHolder currentPlayerHolder;
    private Vector<Player> playerVector;
    private Stack<Command> redoStack;// Stack to store all commands to be redo
    private Stack<Command> commandStack;  // Stack to store executed commands
    private CareTaker careTaker;

    public CreatePlayerCommandFactory(Scanner sc, PlayerFactory pf, CurrentPlayerHolder currentPlayerHolder,
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
            System.out.print("Player ID:- ");
            id = sc.nextLine();
            for (int i = 0; i < playerVector.size(); i++) {
                if (playerVector.get(i).getPlayerID().equals(id)) {
                    throw new PlayerIDExistException();
                }
            }
        } catch (PlayerIDExistException e) {
            System.out.println(e.getMessage());
            System.out.println("Existing player ID:- ");
            return new DisplayAllPlayerCommand(playerVector);
        }

        System.out.print("Player Name:- ");
        String name = sc.nextLine();
        Command c = new CreatePlayerCommand(sc, pf, currentPlayerHolder, playerVector, redoStack,id,name,careTaker);
        commandStack.push(c);
        return c;
    }
}
