public class HumanTest {
    public static void main(String[] args) {
        Human h1 = new Human("Scott");
        Wizard w1 = new Wizard("Ted");
        Ninja n1 = new Ninja("Shawn");
        Samurai s1 = new Samurai("Brianna");
        Samurai s2 = new Samurai("Brianna");
        w1.fireball(h1);
        w1.heal(h1);
        n1.steal(h1);
        s1.runAway();
        s1.deathBlow(h1);
        s1.meditate();
        System.out.println(s2.howMany());
    }
}