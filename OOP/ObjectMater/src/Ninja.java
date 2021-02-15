public class Ninja extends Human {

    public Ninja(String name) {
        super(name);
        super.setStealth(10);
    }
    
    public void steal(Human human) {
    	int s = this.getStealth();
    	System.out.println(this.getName() + " stole " + s + " health from " + human.getName());
    	human.setHealth(human.getHealth() - s);
    	this.setHealth(s + this.getHealth());
    	System.out.println(this.getName() + "'s health is now " + this.getHealth());
    }
    
    public void runAway() {
    	this.setHealth(getHealth() - 10);
    }

}