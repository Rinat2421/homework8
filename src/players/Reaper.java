package players;

public class Reaper extends Hero {

    boolean rage = false;
    boolean ultraRage;
    int degaultHealth = this.getHealth();
    public Reaper(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.Rage);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0) {

            if (this.getHealth() < degaultHealth * 0.30 && rage == false) {
                this.rage = true;
                this.setDamage(getDamage() * 2);
            } else if (this.rage == true && this.getHealth() < degaultHealth * 0.15 && ultraRage == false) {
                this.ultraRage = true;
                this.setDamage(getDamage() + (getDamage()/2));
            }
        }
    }

}


