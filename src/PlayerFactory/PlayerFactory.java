package PlayerFactory;

import Player.*;

public class PlayerFactory implements UserFactory {
    public Player createPlayer(String id,String name){
        return new Player(id,name);
    }
}
