import java.util.ArrayList; //importing ArrayList
import java.util.Scanner; //importing Scanners
public class PokemonRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<Attack> CresseliaAttacks = new ArrayList<Attack>();
		//String description, int powerPointscost, String type, int baseDamage
		 Attack move1 = new Attack("Moonblast", 100, "Fairy", 130); //first move of Cresselia
		 Attack move2 = new Attack("Psycho Cut", 8, "Psychic", 5); // second move of Cresselia
		 Attack move3 = new Attack("Mud-Slap", 20, "Ground", 10); // third move of Cresselia
	     Attack move4 = new Attack("Aurora Beam", 50, "Ice", 80); // fourth move of Cresselia
	     //adding the moves to an ArrayList
	     CresseliaAttacks.add(move1);
	     CresseliaAttacks.add(move2);
	     CresseliaAttacks.add(move3);
	     CresseliaAttacks.add(move4);
	    
	     
	     ArrayList<Attack> RaikouAttacks = new ArrayList<Attack>();
			//String description, int powerPointscost, String type, int baseDamage
			 Attack move5 = new Attack("Extrasensory", 60, "Psychic", 80); //first move of Raikou
			 Attack move6 = new Attack("Thunder Shock", 8, "Electric", 5); // second move of Raikou
			 Attack move7 = new Attack("Shadow Ball", 50, "Ghost", 100); // third move of Raikou
		     Attack move8 = new Attack("Signal Beam", 15 , "Bug", 35); // fourth move of Raikou
		     //adding the moves to an ArrayList
		     RaikouAttacks.add(move5);
		     RaikouAttacks.add(move6);
		     RaikouAttacks.add(move7);
		     RaikouAttacks.add(move8);
		     
		//hitPoints, powerPoints, name, type,attacks
		Pokemon pokemon1 = new Cresselia(125, 100, "Cresselia","Psychic" ,CresseliaAttacks); // Cresselia stats
		Pokemon pokemon2 = new Raikou(105, 100, "Raikou","Electric" ,RaikouAttacks); // Raikou stats
		
		Item item1 = new HyperPotion(); // first item 
		Item item2 = new Ether(); // second item
		ArrayList<Item> i = new ArrayList<Item>(); //ArrayList to store the items for the computer
		//adding items to the arrayList
		i.add(item1); 
		i.add(item2);
		
		int randomItem = (int)(Math.random()*2); // computer will choose which item 
		
		HumanPlayer player1 = new HumanPlayer(pokemon1, item1); // first player which is the user
		
		ComputerPlayer player2 = new ComputerPlayer(pokemon2, i.get(randomItem)); // second player which is the computer
		
		welcome(); // welcoming the user
		player1.usePokemon(pokemon1); // User is sending out Cresselia to battle
		pokemon1.speak(); // Cresselia makes a sound
		player2.usePokemon(pokemon2); // Computer is sending out Raikou to battle
		pokemon2.speak(); // Raikou makes a sound
		
		double total1 = pokemon1.getHitPoints(); // getting Cressilias hit Points
		double total2 = pokemon2.getHitPoints(); // getting Raikous Hit Points
		
		while(total1 != 0 || total2 != 0) { // seeing if the Pokemon's have fainted
		Scanner Player1Scan = new Scanner(System.in); // getting the user's input

		ChooseOption(); //printing out the options
		int index = Player1Scan.nextInt(); //getting the users option
		while(true) { // while loop
		if(index == 2 && (pokemon1.getHitPoints() == pokemon1.getMaxHealth())) { // cannot use the hyper potion if max health
			System.out.println("Choose another option since Pokemon's health is max"); 
			ChooseOption(); //choose a different option if max health
			index = Player1Scan.nextInt();
		}
		else if(index > 3 || index <= 0) { // seeing if the input is any other number besides 1, 2, or 3
			System.out.println("Not a valid option, choose another option");
			ChooseOption(); // printing the options
			index = Player1Scan.nextInt(); // getting the user input again

		}
		else {
			break; //breaking if the option is 1, 2, or 3
		}
		
		}
		
		player1.HumanPlayersMove(player1, index, pokemon2, pokemon1); //passing in the users option
		
		System.out.println("Computers turn: ");
		
		player2.RandomComputerMoves(player2, pokemon1, pokemon2); //passing in the computer option
		System.out.println();
		total1 = pokemon1.getHitPoints(); //getting Cresselia's health after the options
		total2 = pokemon2.getHitPoints(); //getting Raikou's health after the options
		}
		
	}
	static void welcome() { // welcome function to greet user 
		System.out.println("Welcome to the battle\n"); // printing out welcome
	}

	static void ChooseOption() { //printing out the options the users has
		System.out.println("Human Player choose your option: "); 
		System.out.println("1) Attack "); //1 is attack option
		System.out.println("2) UseItem ");//2 is Item option
		System.out.println("3) Run "); //3 is run option
	}
	
}
