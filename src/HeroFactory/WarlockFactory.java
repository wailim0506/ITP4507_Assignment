package HeroFactory;

import Hero.*;


public class WarlockFactory implements HeroFactory {
    public Hero createHero(String id, String name) {
        return new Warlock(id, name);
    }
}
