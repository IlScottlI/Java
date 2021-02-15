
public class Wizard extends Human {

    public Wizard(String name) {
        super(name);
        super.setIntelligence(8);
        super.setHealth(50);
    }

    public void heal(Human human) {
        System.out.println(this.getName() + " healed " + human.getName() + " by " + this.getIntelligence());
        human.setHealth(human.getHealth() + this.getIntelligence());
        System.out.println(human.getName() + "'s health is now " + human.getHealth());
    }

    public void fireball(Human human) {
        // decreases the other human's health by the wizard's intelligence * 3
        int dec = this.getIntelligence() * 3;
        System.out.println(this.getName() + " shot fireball at " + human.getName() + " decreased health by " + dec);
        human.setHealth(human.getHealth() - dec);
        System.out.println(human.getName() + "'s health is now " + human.getHealth());
    }
}