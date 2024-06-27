package players;

import game.RPG_Game;

public class Ludoman extends Hero{


    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.Dice);
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth()>0){
            int firstDice = RPG_Game.random.nextInt(1, 7);
            int secondDice = RPG_Game.random.nextInt(1, 7);

            if (firstDice == secondDice) {
                boss.setHealth(boss.getHealth() - firstDice*secondDice);
            }
            else {
                int randomHero = RPG_Game.random.nextInt(heroes.length);
                heroes[randomHero].setHealth(heroes[randomHero].getHealth()-(firstDice+secondDice));
            }
        }
    }
}
