package players;

import game.RPG_Game;

public class Boss extends GameEntity{

    private SuperAbilityEnum defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbilityEnum getDefence() {
        return defence;
    }

    public void chooseDefence(){
        SuperAbilityEnum[] variants = SuperAbilityEnum.values();
        int randomIndex = RPG_Game.random.nextInt(variants.length);
        this.defence = variants[randomIndex];
    }

    public void attackBoss(Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0){
                continue;
            }
            heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());

        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " Defence = " + this.defence;
    }
}
