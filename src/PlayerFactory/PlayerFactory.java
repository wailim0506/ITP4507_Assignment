package PlayerFactory;

import Player.*;
import Exception.*;
import java.util.*;

public class PlayerFactory {
    public Player createPlayer(String id,String name){
        return new Player(id,name);
    }
}
