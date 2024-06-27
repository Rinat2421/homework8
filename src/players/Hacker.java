package players;

import game.RPG_Game;

public class Hacker extends Hero {

    int hack;
    int hackWhoHeal;

    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.Hack);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (RPG_Game.round%2==0 && this.getHealth()>0) {
            hack=RPG_Game.random.nextInt(1, 21);
            boss.setHealth(boss.getHealth()-hack);
            hackWhoHeal=RPG_Game.random.nextInt(heroes.length);
            if (heroes[hackWhoHeal].getHealth()>0){
                heroes[hackWhoHeal].setHealth(heroes[hackWhoHeal].getHealth()+hack);}
        }
    }
}
