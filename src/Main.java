import HeroFactory.*;
import Hero.*;
import PlayerFactory.*;
import Command.*;
import Player.*;

import javax.sound.midi.SysexMessage;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        HeroFactory n = new WarlockFactory();
//        PlayerFactory p = new PlayerFactory();
//        Player u = p.createPlayer(sc);
//        Hero y = n.createHero(sc);
        Vector<Player> playerVector = new Vector<Player>();
        Stack<Command> commandStack = new Stack<Command>();
        Stack<Command> redoStack = new Stack<Command>();

        while (true) {
            System.out.println("Fantastic World (FW) \n" +
                    "c = create player, g = set current player, a = add hero, m = call hero skill, d \n" +
                    "= delete hero, s = show player, p = display all players, t = change player’s \n" +
                    "name, u = undo, r = redo, l = list undo/redo, x = exit system ");
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :-");
            String input = sc.nextLine();
            switch (input) {
                case "c":
                    break;
                case "g":
                    break;
                case "a":
                    break;
                case "m":
                    break;
                case "d":
                    break;
                case "s":
                    break;
                case "p":
                    break;
                case "t":
                    break;
                case "u":
                    break;
                case "r":
                    break;
                case "l":
                    break;
                case "x":
                    System.exit(0);
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
