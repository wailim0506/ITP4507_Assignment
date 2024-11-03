import HeroFactory.*;
import Hero.*;
import PlayerFactory.*;
import Player.*;
import java.util.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        HeroFactory n = new WarlockFactory();
        PlayerFactory p = new PlayerFactory();
        Player u = p.createPlayer(sc);
        Hero y = n.createHero(sc);
    }
}
