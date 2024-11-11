package PlayerFactory;

import Player.*;

public interface UserFactory {
    public Player createPlayer(String id, String name);
}
