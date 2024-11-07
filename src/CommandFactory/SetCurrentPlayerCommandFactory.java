package CommandFactory;
import Command.*;
import Player.*;
import java.util.*;

public class SetCurrentPlayerCommandFactory implements CommandFactory {
    private Scanner sc;
    private Vector<Player> playerVector;
    private CurrentPlayerHolder currentPlayerHolder;

    public SetCurrentPlayerCommandFactory(Scanner sc, Vector<Player> playerVector, CurrentPlayerHolder currentPlayerHolder) {
        this.sc = sc;
        this.playerVector = playerVector;
        this.currentPlayerHolder = currentPlayerHolder;
    }
    public Command createCommand() {
        return new SetCurrentPlayerCommand(sc,playerVector, currentPlayerHolder);
    }
}
