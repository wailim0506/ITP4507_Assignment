package Memento;

import Hero.*;
import Player.*;
import java.util.*;

public class PlayerMemento implements Memento {
    private String playerID;
    private String playerName;
    private Vector<Hero> heroes;
    private Player player;

    public PlayerMemento(Player player) {
        this.player = player;
        this.playerID = player.getPlayerID();
        this.playerName = player.getPlayerName();
        this.heroes = player.getHeroes();
    }

    public void restore() {
        player.setPlayerName(playerName);
    }
}
