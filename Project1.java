package proj1;


import java.util.ArrayList;
import java.util.Scanner;

// Alexis Krueger, CMSC 215 6381, June 3rd 2024 

public class Project1 {

	public static void main(String [] args) {
	
	/* containsfff
	 do-while loop for user prompts
	 Player object for each player
	 Adds players into an ArrayList --also traversed to find the tallest player with age <= average
	 Average age of players should be computed and returned
	 
	 */
		
	Scanner input = new Scanner(System.in);
	
	ArrayList<Player> players = new ArrayList<>();
	int totalAge = 0;
	
	String choice; 
	
	do {
		System.out.print("Enter player's name, age, and height in feet and inches: ");
		
		String playerData = input.nextLine();
		
		String[] parts  = playerData.split(" ");
		
		String playerName = parts[0];
		
		int playerAge = Integer.parseInt(parts[1]);
		int feet = Integer.parseInt(parts[2]);
		int inches = Integer.parseInt(parts[3]);
		
		Player player = new Player(playerName, new Height(feet,inches), playerAge); 
		players.add(player);
		totalAge += playerAge;
		
		System.out.print("Do you want to add another player? [yes/no]");
		choice = input.next();
		input.nextLine();
		
	} while (choice.equalsIgnoreCase("yes"));
	
	// Average = total of ages divided by the size of the array
	double averageAge = (double) totalAge / players.size();
	System.out.print("The average age of all players is " + averageAge);
	
	// Finding tallest player
	
	Player tallestPlayer = null;
	int maxHeight = Integer.MIN_VALUE;
	
	for (Player player : players) {
		if (player.getAge() <= averageAge && player.getHeight().toInches() > maxHeight) {
			tallestPlayer = player;
			maxHeight= player.getHeight().toInches();
		}
	}
	if (tallestPlayer != null) {
		System.out.println("\nThe tallest player whose age is less than the average is: ");
		System.out.println(tallestPlayer);
	} else {
		System.out.println("No player meets the criteria.");
	}
	input.close();
}
}

