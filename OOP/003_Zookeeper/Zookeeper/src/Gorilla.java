
public class Gorilla extends Mammal {
	
	public void throwSomething(){
		System.out.println("Gorilla has thrown something");
		super.setEnergyLevel(super.getEnergyLevel() - 5); 
	}
	
	public void eatBananas(){
		System.out.println("Gorilla Satisfaction");
		super.setEnergyLevel(super.getEnergyLevel() + 10); 
	}
	
	public void climb(){
		System.out.println("Gorilla has climbed a tree");
		super.setEnergyLevel(super.getEnergyLevel() - 10);
	}
}
