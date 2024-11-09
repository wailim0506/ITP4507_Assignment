package HeroFactory;

import Hero.*;
import java.util.*;

public class WarlockFactory implements HeroFactory {
    public Hero createHero(Scanner sc, String id, String name) {
        return new Warlock(id, name);
    }
}
