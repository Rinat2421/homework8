package players;

public class Spitfire extends Hero {

    public Spitfire(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.Agression);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth()>0){


            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth()==0){
                    boss.setHealth(boss.getHealth()-80);
                }
            }
        }
    }
}