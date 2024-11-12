package HeroFactory;

import Hero.*;

public class WarriorFactory implements HeroFactory {
    public Hero createHero(String id, String name) {
        return new Warrior(id, name);
    }
}
