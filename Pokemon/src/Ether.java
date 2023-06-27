
public class Ether implements Item{ //Item - Ether
	private double ether; //Gives power points
	Ether(){ // default constructor
		ether = 30; // base power points given is 30
	};
	public double getEther() { //getter method to get the Ether
		return ether; // returning the Ether
	}
	public void use(Pokemon p) { //using the Ether on the Pokemon method
		if(p.getPowerPoints() < p.getMaxPowerPoints()) { //checking to see if giving it the Ether wont surpass its max power points
		System.out.println("The Computer player has used an ether " + p.getName()); //only computer player gets the Ether
		if(p.getPowerPoints() + getEther() > p.getMaxPowerPoints()) { //checking to see if giving the Pokemon the Ether will be less than the max power points
			p.setPowerPoints(p.getMaxPowerPoints()); //setting the power points to max since it surpasses the max
			System.out.println(p.getName() + " power points is now " + p.getPowerPoints());
		}
		else {
		p.setPowerPoints(p.getPowerPoints()+ getEther()); //else set the power points to the Ether plus the Pokemon's own power points
		System.out.println(p.getName() + " power points is now " + p.getPowerPoints()); //printing the stats
		}
		}
		else {
			System.out.println("The Pokemon has max power points, cannot use the Item"); //else you already have max power points
		}
	}
}
