package CommandFactory;
import Command.*;
public class ExitCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new ExitCommand();
    }
}
