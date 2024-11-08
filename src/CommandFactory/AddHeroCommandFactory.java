package CommandFactory;
import Command.*;
import Memento.*;
import Player.*;
import HeroFactory.*;
import java.util.*;

public class AddHeroCommandFactory implements CommandFactory {
    private Scanner sc;
    private CurrentPlayerHolder currentPlayerHolder;
    private String id;
    private String name;
    private HashMap<String, HeroFactory> HeroFactory;
    private HashMap<String, String> HeroTypeHashMap;
    private Stack<Command> commandStack;
    private Stack<Command> redoStack;
    private Vector<Player> playerVector;
    private CareTaker careTaker;

    public AddHeroCommandFactory(Scanner sc, CurrentPlayerHolder currentPlayerHolder, HashMap<String, HeroFactory> HeroFactory,
                                 HashMap<String, String> HeroTypeHashMap,Stack<Command> commandStack, Stack<Command> redoStack,
                                 Vector<Player> playerVector, CareTaker careTaker) {
        this.sc = sc;
        this.currentPlayerHolder = currentPlayerHolder;
        this.HeroFactory = HeroFactory;
        this.HeroTypeHashMap = HeroTypeHashMap;
        this.commandStack = commandStack;
        this.redoStack = redoStack;
        this.playerVector = playerVector;
        this.careTaker = careTaker;
    }

    public Command createCommand() {
        if (currentPlayerHolder.getCurrentPlayer() != null) {
            //check hero id and name input below, if invalid, ask again until correct, avoid creating command with wrong input
            while(true){
                try{
                    System.out.print("Please input hero information (id, name):- ");
                    String idName = sc.nextLine();
                    String[] split = idName.split(", ");
                    id = split[0];
                    name = split[1];
                    break;
                }catch (Exception e){
                    System.out.println("Invalid input");
                }
            }

            //check hero type input below, if invalid, ask again until correct, avoid creating command with wrong input
            while (true){
                System.out.print("Hero Type (1 = Warrior | 2 = Warlock ):- ");
                String heroType = sc.nextLine();
                if (HeroFactory.get(heroType) != null){
                    Command c =  new AddHeroCommand(sc,currentPlayerHolder,HeroFactory,redoStack,id,name,heroType,HeroTypeHashMap,careTaker);
                    commandStack.push(c);
                    return c;
                }else{
                    System.out.println("Invalid hero type");
                }
            }
        }else{
            System.out.println("No player to add hero");
            //return a command with no undo/redo to avoid error
            return new DisplayAllPlayerCommand(playerVector);
        }
    }
}
