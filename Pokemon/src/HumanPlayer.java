import java.util.Scanner;

public class HumanPlayer extends Player { // Human Player class
	
	public HumanPlayer(Pokemon p, Item I) { // constructor for the Human player
		super(p,I); // using parents constructor to set the Human Players Pokemon and Item
	}
	public void attackPokemon(Pokemon p,Pokemon other ,int index) { // Human player's attack method
		p.attack(other, index); // Pokemon attacks enemies Pokemon with the index of the attack
	}
	public void useItem(Pokemon p){ //option 3 is using the item
		
		use(p); //using item on Pokemon
	}
	public void run() { //running away method
		System.out.print("The Human player has fled the scene ");
		System.exit(0); //exiting the system once the player has ran away
	}
	 void HumanPlayersMove(HumanPlayer player, int index, Pokemon other, Pokemon p) { //human player options
			
			Scanner Player1Scan = new Scanner(System.in); //making a scanner
			
			if(index == 1) { //if the index is 1
				
			while(true) { 
				int j = 0; //number associated with the attack
				System.out.println("Choose an Attack");
				for(Attack a : p.getAttacks()) { // looping through the attacks
					System.out.println(j + ") "+a.getDescription()); // assigning a number with the attack
					j++; // increasing the number
				}
				
				int AttackIndex = Player1Scan.nextInt(); // selecting which attack the user wants to use
				if(p.getAttacks().get(AttackIndex).getPowerPointCost() > p.getPowerPoints() ) { // checking to see if your attack has enough power points
					if(p.getPowerPoints() == 0) { // if the power points is 0 
						p.setPowerPoints(p.recover()); //recovering the power points
						System.out.println(p.getName() + " is out of Power Points, need to rest for one turn");
						break;
					}
					System.out.println("Not enough mana, choose another attack"); //telling user not enough power points for the attack
				}
				else {
				player.attackPokemon(p,other, AttackIndex); // else I attack the enemy
				break;
				}
			}
				}
			else if(index == 2) { // if index is 2
				player.useItem(p); // use the item
				
			}
			
			else if(index == 3){ //if index is 3
				player.run(); // you run away
			}
		}
	
}
