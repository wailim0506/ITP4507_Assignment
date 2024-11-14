package Player;

import Hero.*;

import java.util.Vector;

public class Player {
    private String playerID;
    private String playerName;
    private Vector<Hero> heroes;

    public Player(String playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
        heroes = new Vector<>();
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Vector<Hero> getHeroes() {
        return heroes;
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void removeHero(Hero hero) {
        heroes.remove(hero);
    }

    public void showPlayerDetails() {
        System.out.println("Player " + getPlayerName() + " (" + getPlayerID() + ")");
        System.out.println("Heroes: ");
        Vector<Hero> playerHeroVector = getHeroes();
        if (!heroes.isEmpty()) {
            for (int i = 0; i < heroes.size(); i++) {
                playerHeroVector.get(i).showHeroStatus();
            }
        } else {
            System.out.println("No hero to show");
        }
    }
}
