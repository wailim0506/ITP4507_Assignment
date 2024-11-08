package Player;

public class CurrentPlayerHolder {
    private Player currentPlayer;

    public CurrentPlayerHolder(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
