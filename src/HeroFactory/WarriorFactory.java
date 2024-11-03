package HeroFactory;

import Hero.*;
import java.util.*;
public class WarriorFactory implements HeroFactory {
    public Hero createHero(Scanner sc) {
        //should put in main
        System.out.print("Please input hero information (id, name):- ");
        String idName = sc.nextLine();
        String[] split = idName.split(", ");
        String id = split[0];
        String name = split[1];
        return new Warrior(id, name);
    }
}
