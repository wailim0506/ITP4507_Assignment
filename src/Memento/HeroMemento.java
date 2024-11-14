package Memento;
import Hero.*;

public class HeroMemento implements Memento {
    private String heroName;
    private int hp;
    private int damage;
    private int mp;
    private int defencePoint;
    private Hero hero;

    public HeroMemento(Hero hero) {
        this.hero = hero;
        this.heroName = hero.getHeroName();
        this.hp = hero.getHp();
        this.damage = hero.getDamage();

        String heroType = hero.getClass().getSimpleName();
        System.out.println(heroType);

        if (hero instanceof Warlock) {
            this.mp = ((Warlock) hero).getMp();
        }else if(hero instanceof Warrior){
            this.defencePoint = ((Warrior) hero).getDefencePoint();
        }
    }

    public void restore() {
        hero.setHeroName(heroName);
        hero.setHp(hp);
        hero.setDamage(damage);
        if (hero instanceof Warlock) {
            ((Warlock) hero).setMp(mp);
        }else if(hero instanceof Warrior){
            ((Warrior) hero).setDefencePoint(defencePoint);
        }
    }
}
