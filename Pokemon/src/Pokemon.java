import java.util.ArrayList; //importing Array List

public abstract class Pokemon{ //Pokemon class

	private double hitPoints; // Pokemon's hit points
	private double powerPoints; // Pokemon's power points
	private String name; // Pokemon's name
	private ArrayList<Attack> attacks = new ArrayList<Attack>(); //Pokemon's attacks
	private double MaxHealth; // Pokemon's max health 
	private double MaxPowerPoints; // Pokemon's max power points
	private String PokemonType; //
	
	public Pokemon(double hp, double pp, String name, String PT, ArrayList<Attack> attacks) { // constructor 
		setHitPoints(hp); //setting hit points in the constructor
		setPowerPoints(pp); //setting power points in the constructor
		setName(name); // setting the name in the constructor
		setAttacks(attacks); // setting the attacks in the constructor\
		setPokemonType(PT);
		MaxHealth = hp; //setting the max health
		MaxPowerPoints = powerPoints; //setting the max power points
	}
	public double getMaxHealth() { //getter for the max health 
		return MaxHealth; //returning the max health
	}
	public double getMaxPowerPoints() { //getter for the max power points
		return MaxPowerPoints; //returning the max power points
	}
	
	public abstract void attack(Pokemon other, int attackIndex); // abstract void method attack
	
	public void PokemonsAttack(Pokemon other, int attackIndex) { // The Pokemon's attacks damage
		double total; // default variable 
		//checking to see if the attack is super effective and that there is enough power points
		if(attacks.get(attackIndex).isSuperEffective(other) && getPowerPoints() > attacks.get(attackIndex).getPowerPointCost()) {
			total = other.getHitPoints() - (attacks.get(attackIndex).getBaseDamage()*2); //setting the total to double the damage
			if(total <= 0) { //checking to see if the enemy Pokemon is dead
				System.out.println("The move " + attacks.get(attackIndex).getDescription() +" by " + getName()+ " was super effective to " + other.getName());
				System.out.println(other.getName() + " has been deafeated");
				other.setHitPoints(total); //reducing the enemy's damage
				setPowerPoints(getPowerPoints()-attacks.get(attackIndex).getPowerPointCost());
				System.out.println("The Power Points of " + getName() +" is " + getPowerPoints());
				System.exit(0); // if the enemy Pokemon dies you cant input anything else

			}
			else{
			//else the Pokemon still has health 
			setPowerPoints(getPowerPoints()-attacks.get(attackIndex).getPowerPointCost()); // subtract your own Pokemon's power points with the cost of the attack

			other.setHitPoints(total); // setting the hit points of the enemy
			//printing out the stats of both the pokemons
			System.out.println("The move " + attacks.get(attackIndex).getDescription()+" by " + getName() +" was super effective to "+ other.getName());
			System.out.println("The health of " + other.getName() +" is " + other.getHitPoints());
			System.out.println("The Power Points of " + getName() +" is " + getPowerPoints());
		}
		
		}
		//checking to see if the attack is not effective and that there is enough power points
		else if(attacks.get(attackIndex).isNotEffective(other) && getPowerPoints() > attacks.get(attackIndex).getPowerPointCost()) {
			total = other.getHitPoints() - (attacks.get(attackIndex).getBaseDamage()/2); // setting the total to the enemys health an subtracting that by half the base damage
			if(total <= 0) { // checking to see if the enemy has died
				//print statement to print the damage and the that the enemy has been defeated
				System.out.println("The move " + attacks.get(attackIndex).getDescription()+ " by "+ getName() +" was not effective to "+ other.getName());
				System.out.println(other.getName() + " has been deafeated");
				other.setHitPoints(total); // setting the hitpoints of the enemy to 0
				setPowerPoints(getPowerPoints()-attacks.get(attackIndex).getPowerPointCost()); //setting power points of the pokemon
				System.out.println("The Power Points of " + getName() +" is " + getPowerPoints());
				System.exit(0); //exiting if the enemy has been defeated

			}
			else {
				// else the enemys pokemon is still alive
			setPowerPoints(getPowerPoints()-attacks.get(attackIndex).getPowerPointCost()); //setting the power points
			other.setHitPoints(total); //setting enemy's pokemons health
			//print statements to print the stats of both Pokemon's
			System.out.println("The move " + attacks.get(attackIndex).getDescription()+ " by "+ getName() +" was not effective to "+ other.getName());
			System.out.println("The health of " + other.getName() +" is " + other.getHitPoints());
			System.out.println("The Power Points of " + getName() +" is " + getPowerPoints());
			}
		
		}
		//seeing if the Pokemon has enough power points to attack since this is the base damage
		else if(getPowerPoints() > attacks.get(attackIndex).getPowerPointCost() ) {
			total = other.getHitPoints() - attacks.get(attackIndex).getBaseDamage(); // setting total
			if(total <= 0) { // if Pokemon has fainted
				//print statements to display the stats of the Pokemon's
				System.out.println("The move " + attacks.get(attackIndex).getDescription()+" by " + getName() +" did " + attacks.get(attackIndex).getBaseDamage() + " damage to "+ other.getName());
				System.out.println(other.getName() + " has been deafeated");
			other.setHitPoints(total); //setting the enemys health to 0
			setPowerPoints(getPowerPoints() - attacks.get(attackIndex).getPowerPointCost()); //setting the power points
			System.out.println("The Power Points of " + getName() +" is " + getPowerPoints());
			System.exit(0); //exiting since the Pokemon has been defeated

		}
			else {
				//setting the enemys health to their health and subtracting damage the attack did 
			setPowerPoints(getPowerPoints()-attacks.get(attackIndex).getPowerPointCost());
			other.setHitPoints(total);
			System.out.println("The move " + attacks.get(attackIndex).getDescription()+" by " + getName() +" did " + attacks.get(attackIndex).getBaseDamage() + " damage to " + other.getName());
			System.out.println("The health of " + other.getName() +" is " + other.getHitPoints());
			System.out.println("The Power Points of " + getName() +" is " + getPowerPoints());

		}
		
		}

		else {
			//else the attack will have no effect on the enemy
			System.out.println(attacks.get(attackIndex).getDescription() + " has no effect on " + other.getName()); //telling the user the attack has no effect
			setPowerPoints(getPowerPoints()-attacks.get(attackIndex).getPowerPointCost());  // setting the power points
			//printing the Pokemon's stats
			System.out.println("The Power Points of " + getName() +" is " + getPowerPoints());
			System.out.println("The health of " + other.getName() +" is " + other.getHitPoints());
		}
	}
	public abstract void speak(); //abstract void method speak


	
	public double recover() { //method to recover power points when its low
		 return getMaxPowerPoints()/2; //restoring half the power points
	}

	public double getHitPoints() { //getter method to get the hit points
		return hitPoints; //returning the hit points
	}

	public void setHitPoints(double hitPoints) { //setter method for the hit points
		this.hitPoints = hitPoints; //setting the hit points
	}

	public double getPowerPoints() { //getter method to get the power points
		return powerPoints; //returning the power points
	}

	public void setPowerPoints(double powerPoints) { //setter method for the power points
		this.powerPoints = powerPoints; // setting the power points
	}

	public String getName() { //getter method to get the name
		return name; // returning the name
	}

	public void setName(String name) { //setter method to set the name
		this.name = name; //setting the name
	}

	public ArrayList<Attack> getAttacks() { //getter method for the attacks
		return attacks; // returning the attacks
	}

	public void setAttacks(ArrayList<Attack> attacks) { //setter method for the attacks
		this.attacks = attacks; //setting the attacks
	}
	public String getPokemonType() { //getter method for the Pokemon's type
		return PokemonType; //returning the type
	}
	public void setPokemonType(String pokemonType) { // setter method for the Pokemon's type
		PokemonType = pokemonType; // setting the type
	}
}




