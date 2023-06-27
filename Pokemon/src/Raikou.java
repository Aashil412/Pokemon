import java.util.ArrayList; //importing the ArrayList

public class Raikou extends Pokemon { // Pokemon - Raikou

	public Raikou(double hp, double powerPoints, String name, String PT, ArrayList<Attack> attacks) {//Raikou's constructor
		super(hp, powerPoints, name, PT, attacks); //setting Raikou's stats  
	}
	
	public void attack(Pokemon other, int attackIndex) {// attack method 
		PokemonsAttack(other, attackIndex);//calling function from Pokemon class
	}

	public void speak() {//Raikou speaking
		System.out.println("Growls\n"); // His voice calls

	}

}
