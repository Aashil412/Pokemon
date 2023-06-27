
public class ComputerPlayer extends Player{ //The Computer Player class

	
	public ComputerPlayer(Pokemon p, Item I) {  // constructor for the Computer player
		super(p,I);// using parents constructor to set the Computer Players Pokemon and Item
	}
	public void attack(Pokemon p,Pokemon other, int index) {// Computer player's attack method
		p.attack(other, index);// Pokemon attacks enemies Pokemon with the index of the attack
	}
	public void useItem(Pokemon p) {//option 3 is using the item
		use(p);//using item on Pokemon
	}
	public void run() {//running away method
		System.out.println("The Computer Player has fled the scene ");
		System.exit(0); //exiting the system once the player has ran away
	}
	void RandomComputerMoves(ComputerPlayer player2, Pokemon other, Pokemon p) { //random computer move function
		double randIdx = Math.random(); // getting the computers choice of option they want to do
		
		if(randIdx <= 0.6) { // if the randIdx is less than 0.6 they attack the user
			while(true) {
			int ranAttack = (int)(Math.random()*4); // getting a random Raikou attack
			if(p.getAttacks().get(ranAttack).getPowerPointCost() <= p.getPowerPoints()) { //seeing if there is enough power points
				player2.attack(p,other, ranAttack); //attacking the user
				break;
			}
			if(p.getPowerPoints() == 0) { //if the power points is 0
				p.setPowerPoints(p.recover()); // the computer needs to rest its Pokemon for one turn
				System.out.println(p.getName() + " is out of Power Points, need to rest for one turn");
				break;
			}
		}
		
		}
		else if(randIdx <= 0.9) { //if its less than 0.9
			while(true) {
				//checking to see if the Pokemon's health or power points is max so you cant use the item
				if(p.getHitPoints() == p.getMaxHealth() || p.getPowerPoints() == p.getMaxPowerPoints()) {
					double randomIndex = Math.random(); //giving the computer a different option
					if(randomIndex < 0.9) { // if its less than 0.9
						int ranAttack = (int)(Math.random()*4); // computer will attack using a random Raikou move
						if(p.getAttacks().get(ranAttack).getPowerPointCost() <= p.getPowerPoints()) { //checking to see if theres enough power points
							player2.attack(p,other, ranAttack); // attacking the enemy Pokemon if there is
							break;
						}
						if(p.getPowerPoints() == 0) { // if the Power Points is 0
							p.setPowerPoints(p.recover()); // Pokemon needs to recover
							System.out.println(p.getName() + " is out of Power Points, need to rest for one turn");
							break;
						}
					}
					else { //else the Computer player will run
						player2.run();
						break;
					}
				}
				else { // if the Pokemon's health or Power Points is not max
			player2.useItem(p); // the Computer can use the Item
			break;
				}
		}
		}
		else{ // else the computer runs away
			player2.run();
			
		}
	}
	
}
