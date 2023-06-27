public class Attack{

private String description; //The attacks description 
private int powerPointscost; // the attacks Power points cost
private String type; // the attack type
private int baseDamage; //the base damage of the attack


public Attack() { //default constructor
	description = ""; // empty name
	powerPointscost = 0; // power point cost is 0
	type = "None"; // type is none
	baseDamage = 0; //base damage is 0
}

public Attack(String description, int powerPointscost, String type, int baseDamage) { //constructor for attack

	this.description = description; //setting the description in the constructor 
	this.powerPointscost = powerPointscost; //setting the power point cost in the constructor 
	this.type = type;//setting the type in the constructor 
	this.baseDamage = baseDamage;//setting the base damage in the constructor 
	
}
public boolean isSuperEffective(Pokemon other) { //super effective method
	if(getType() == "Ground" && (other.getPokemonType() == "Electric")) { // if the attack type is ground the enemy is Electric 
		return true; //move is super effective
	}
	else if(getType() == "Bug" &&(other.getPokemonType() == "Psychic")) { // if the attack type is bug and the enemy is Psychic
		return true; //move is super effective
	}
	return false; //else its a different effectivness 
}
public boolean isNotEffective(Pokemon other) { //not effective method
	if(getType() == "Psychic" && (other.getPokemonType() == "Psychic")) { // if the attack type is Psychic and the enemy is Psychic 
		return true; //return true
	}
	return false; //else its a different effectivness 
}
public boolean hasNoEffective(Pokemon other) { //move has no effect method
	if(getType() == "Ghost" && (other.getPokemonType() == "Psychic")) { //if the attack type is ghost and the other type is Psychic
		return true; //return true
	}
	return false; //else its a different effectivness 
}



public int getPowerPointCost(){ //getter method to get the power points cost
	return powerPointscost; //returning the power points cost
}
public String getType() { //getter method to get the attack type
	return type; // returning the attack type
}
public int getBaseDamage() { //getter method to get the base damage
return baseDamage; //returning the base damage
}
public String getDescription() { //getter method to get the description
	return description; //returning the description
}

}
