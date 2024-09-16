// Alexis Krueger, Project 1,  June 4th 2024

package proj1;
public class Player {
	
	/* 
	 * 
	 * contains the following -
	 instance variables : 
	 str players name
	 str players height stored as the type Height
	 int players age
	 
	 methods : 
	 getter methods for instance variables
	 toString returns string representation of the player's details w/labels
	 constructor accepting variables into a Player object
	 *
	 */
	
	// Instance variables 
	private String playerName;
	private Height playerHeight; //stored as Height object
	private int playerAge;
	 
	// Object constructor 
	public Player(String playerName, Height playerHeight, int playerAge) {
		this.playerName = playerName;
		this.playerHeight = playerHeight;
		this.playerAge = playerAge;
	}
	
	// Getter methods
	public String getName() {
		return playerName;
	}
	public Height getHeight() {
		return playerHeight;
	}
	public int getAge() {
		return playerAge;
	}
	
	// toString method
	public String toString() {
		return "   Name: " + playerName + 
				" Age: " + playerAge 
				+ " "+ playerHeight.toString(); // Call toString() method of Height 
	}

}