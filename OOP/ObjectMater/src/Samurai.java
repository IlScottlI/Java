
public class Samurai extends Human {
	 int counter = 0; 
	 public Samurai(String name) {
	        super(name);
	        super.setHealth(200);
	        counter++;
	    }
	 	
	 public void runAway() {
		 this.setHealth(getHealth()-10);
		 System.out.println(this.getName() + " ran away from battle, removed 10 from health." );
	 }
	 public void deathBlow(Human human) {
		 human.setHealth(0);
		 System.out.println("DEATH BLOW " + this.getName() + " Killed " + human.getName());
		 this.setHealth(Math.floorDiv(this.getHealth(), 2));
		 System.out.println(this.getName() + "'s health was reduced by half, total health is now " + this.getHealth() );
	}
	 public void meditate() {
		 int increase = Math.floorDiv(this.getHealth(), 2);
		 this.setHealth(getHealth()+increase);
		 System.out.println(increase);
	 }
	 public int howMany() {
		 return counter;
	 }
}
