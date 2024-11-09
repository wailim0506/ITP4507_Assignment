package HeroFactory;

import Hero.*;
import java.util.*;
public class WarriorFactory implements HeroFactory {
    public Hero createHero(Scanner sc, String id, String name) {
        return new Warrior(id, name);
    }
}
