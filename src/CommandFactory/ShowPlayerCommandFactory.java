package CommandFactory;
import Command.*;
import Product.*;

public class ShowPlayerCommandFactory implements CommandFactory {
    private CurrentPlayerHolder currentPlayerHolder;

    public ShowPlayerCommandFactory(CurrentPlayerHolder currentPlayerHolder) {
        this.currentPlayerHolder = currentPlayerHolder;
    }

    public Command createCommand() {
        return new ShowPlayerCommand(currentPlayerHolder);
    }
}
