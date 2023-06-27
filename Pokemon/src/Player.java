
public abstract class Player{ //Player class

	private Pokemon pokemon; // Player has a Pokemon
	private Item item; // Player has an Item

	
	public Player(Pokemon p, Item I) { // constructor
		pokemon = p; //setting the user's Pokemon in the constructor
		item = I; // setting the user's Item in the constructor 
	}
	public Pokemon getPokemon() { //getter method to get the Pokemon
		return pokemon; //returning the Pokemon
	}
	public abstract void run(); // abstract void method
	
	public Item getItem() { //getter method to get the Item
		return item; //returning the Item
	}
	public void setItem(Item i) { // setter method to set the Item
		item =i; // setting the Item
	}
	public void usePokemon(Pokemon p) { //sending out the Pokemon to battle 
		System.out.println("Go " + p.getName() + " into battle\n"); //Printing the Pokemon's name 
		
	}
	
	public void use(Pokemon p){ //using the item method
		item.use(p);
	}
}
