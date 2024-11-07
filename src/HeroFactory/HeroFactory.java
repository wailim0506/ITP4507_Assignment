package HeroFactory;
import Product.*;

import java.util.*;

public interface HeroFactory {
    Hero createHero(Scanner sc, String id, String name);
}
