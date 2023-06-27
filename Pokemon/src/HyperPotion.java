
public class HyperPotion implements Item{ // Hyper Potion item class
private int hyper_potion; // hyper potion variable
	HyperPotion(){
		hyper_potion = 120; //setting the hyper potion in the constructor 
	}
	public int getHyperPotion() { //getter method for the hyper potion
		return hyper_potion; //returning the hyper potion
	}
	public void use(Pokemon p) { // use method to use an item on a Pokemon
//		if(p.getHitPoints() == p.getMaxHealth()) { //checking to see if the health is already max
//			System.out.println("Cannot use Hyper Potion on " + p.getName() + " since the health is max"); 
//		}
		if(getHyperPotion() + p.getHitPoints() <= p.getMaxHealth()) { //checking to see if the hyper potion wont heal till full
			p.setHitPoints(p.getHitPoints() + getHyperPotion());
			System.out.println("The player has used a Hyper Potion on " + p.getName() + " and the health is " + p.getHitPoints());

		}
		else {
			p.setHitPoints(p.getMaxHealth()); //the Pokemon can only recieve max health if adding its current health wirh the hyper potion
			System.out.println("The player has used a Hyper Potion on " + p.getName() + " and the health is " + p.getHitPoints());
		}
		
	}
	public int getItem() { //getter method for the Item
		return hyper_potion; // returning the item
	}

}
