package CommandFactory;
import Command.*;
import Player.*;
import java.util.*;

public class DisplayAllPlayerCommandFactory implements CommandFactory {
    private Vector<Player> playerVector;

    public DisplayAllPlayerCommandFactory(Vector<Player> playerVector) {
        this.playerVector = playerVector;
    }
    public Command createCommand() {
        return new DisplayAllPlayerCommand(playerVector);
    }
}
