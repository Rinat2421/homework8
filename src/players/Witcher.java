package players;

import game.RPG_Game;

public class Witcher extends Hero{
    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.Resurrection);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()==0 && this.getHealth()>0){
                heroes[i].setHealth(this.getHealth());
                System.out.println("Witcher воскресил " + heroes[i].getName());
                this.setHealth(0);
                break;
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {

            RPG_Game.startGame();
        }
    }
}
