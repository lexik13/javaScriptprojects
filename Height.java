// Alexis Krueger, Project 1,  June 4th 2024

package proj1;
public class Height {
	
   /*
	*  
	*  contains the following -
	instance variables : 
	int feet
	int inches
	
	methods : 
	toInches returns height in total inches
	toString returns string representation of height w/ single quote then double quote
	constructor accepting variables into Height object
	*
	*/
	
	private int feet;
	private int inches;

	// Creating a constructor that accepts ft & in for a Height Object
	public Height(int feet, int inches) {
		this.feet = feet;
		this.inches = inches;
		
	}
	
	// Method to convert height into total inches
	public int toInches() { 
		return feet * 12 + inches;
	}
	
	// Return statement with ' and "
	@Override
	public String toString () { 
		return "Height: " + feet + "' " + inches + "\" ";
	}
}
	