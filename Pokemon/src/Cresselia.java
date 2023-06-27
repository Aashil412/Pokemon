import java.util.ArrayList; //importing ArrayList
public class Cresselia extends Pokemon{ //Pokemon - Cresselia
		
	public Cresselia(double hp, double powerPoints, String name, String PT, ArrayList<Attack> attacks) { //Cresselia's constructor
			super(hp, powerPoints, name, PT, attacks); //setting Cresselia's stats  
		}
	
		public void attack(Pokemon other, int attackIndex) { // attack method 
			PokemonsAttack(other, attackIndex); //calling function from Pokemon class
		}
		public void speak() { //Cresselia speaking
			System.out.println("Screeech\n"); //Her voice calls
		}
}

