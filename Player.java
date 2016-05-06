/** 
 * This is the Player class for the Wheel of Fortune game.
 * 
 * This is where the different names for the players are entered at the start of the game.
 * These names are stored to variables and used throughout the game.
 * 
 * @version 1.0
 * @author Genaro Bedenko
 */

import java.util.Scanner;

public class Player extends Game {
	
	// enterPlayer1Name allow the player to enter an input which is stored in a variable as their name
	public static void enterPlayer1Name() {
		
		String input;
			
		System.out.println("Please enter the name for Player 1:");
		
		// Take the user's input
		Scanner scan = new Scanner(System.in);
													
		// Save the user's input to a variable
		input = scan.nextLine();
		
		player1name = input;
		
		System.out.println("The name for player 1 is " + player1name);
		System.out.println(" ");
				
	}
	
	// enterPlayer2Name allow the player to enter an input which is stored in a variable as their name
	public static void enterPlayer2Name() {
		
		String input;
			
		System.out.println("Please enter the name for Player 2:");
		
		// Take the user's input
		Scanner scan = new Scanner(System.in);
													
		// Save the user's input to a variable
		input = scan.nextLine();
		
		player2name = input;
		
		System.out.println("The name for player 2 is " + player2name);
		System.out.println(" ");
	}
	
	// enterPlayer3Name allow the player to enter an input which is stored in a variable as their name
	public static void enterPlayer3Name() {
		
		String input;
			
		System.out.println("Please enter the name for Player 3:");
		
		// Take the user's input
		Scanner scan = new Scanner(System.in);
													
		// Save the user's input to a variable
		input = scan.nextLine();
		
		player3name = input;
		
		System.out.println("The name for player 3 is " + player3name);
		System.out.println(" ");
		
	}
	
}
