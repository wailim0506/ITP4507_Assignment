package HeroFactory;
import Hero.*;

public interface HeroFactory {
    Hero createHero(String id, String name);
}
