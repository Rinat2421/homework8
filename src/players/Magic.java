package players;

import game.RPG_Game;

public class Magic extends Hero{

    private int boost;

    public Magic(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.Boost);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth()>0){


            for (int i = 0; i < heroes.length; i++) {
                boost = RPG_Game.random.nextInt(1, 5);
                heroes[i].setDamage(heroes[i].getDamage() + boost);
            }}
    }
}
