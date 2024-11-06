package Exception;

public class PlayerIDExistException extends Exception {
    public PlayerIDExistException() {
        super("Player ID already exists");
    }
}
