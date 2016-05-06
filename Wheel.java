/**
 * This is the Wheel class for the Wheel of Fortune game.
 * 
 * This is where the player spins the wheel.
 * 
 * It will land on a random segment on the wheel.
 * If it lands on an amount segment it will move on to letting the player guess a letter.
 * If it lands on a non-amount segment, it will operate its function.
 * 
 * @version 1.0
 * @author Genaro Bedenko
 */

import java.util.*;

public class Wheel extends Game {
		
	// spinWheel method asks the user for an input to spin the wheel
	public static void spinWheel() {
		
		// Determine whose turn it is before they spin the wheel
		if (playerTurn == 1) {
			
			currentPlayer = player1name;
		}
		if (playerTurn == 2) {
			
			currentPlayer = player2name;
		}
		if (playerTurn == 3) {
			
			currentPlayer = player3name;
		}
		if (playerTurn == 4) {
			
			currentPlayer = player1name;
			
			// If the turn counter has reached 4, reset it to 1
			playerTurn = 1;
		}
		
		// Allow the user to spin the wheel
		int input;
					
		System.out.println("If you are ready to spin the wheel, Player " + currentPlayer + " enter 1:");
				
		// Take the user's input
		Scanner scan = new Scanner(System.in);
							
		// Save the user's input to a variable
		input = scan.nextInt();
				
			if (input == 1) {
					
				Wheel.landWheel();
			}
			
			else {
				
				Wheel.spinWheel();
			}
				
				
	}
	
	// landWheel method gives an output for which segment the wheel lands on
	public static void landWheel() {
		
		// Declare the results of the wheel spin
		int[] wheelAmounts = {400, 1000, 900, 500, 200, 700, 450, 1000, 400, 750, 400, 150, 600, 400, 1000, 800, 250, 500, 300, 200};

		// Create a random number generator
		Random rndGenerator = new Random();
	
		// Generate a random number 0 to 23 (For the 24 possible results)
		// Save the number to a variable
		int spinResult = rndGenerator.nextInt(23);	
	
		// If the result is 20 to 23, print out the other segments (e.g. Bankrupt, Free Spin, etc.)
		if (spinResult == 20) {
		
			System.out.println("The wheel landed on Lose a Turn");
			System.out.println(" ");
			System.out.println("Since you landed on Lose a Turn, play passes to the next player");
			System.out.println(" ");
			playerTurn = playerTurn + 1;
			Wheel.spinWheel();
		}else
		
		if (spinResult == 21) {
		
			System.out.println("The wheel landed on Bankrupt");
			System.out.println(" ");
			
			if (playerTurn == 1) {
				
				player1total = 0;
				
			}
			
			if (playerTurn == 2) {
				
				player2total = 0;
				
			}
			
			if (playerTurn == 3) {
				
				player3total = 0;
				
			}
			
			System.out.println("Your total has been reduced to 0");
			System.out.println(" ");
			System.out.println("Since you landed on Bankrupt, play passes to the next player");
			System.out.println(" ");
			playerTurn = playerTurn + 1;
			Wheel.spinWheel();
		}else
		
		if (spinResult == 22) {
		
			System.out.println("The wheel landed on Free Spin");
			System.out.println(" ");
			Wheel.spinWheel();
		}else
		
		if (spinResult == 23) {
			
			System.out.println("The wheel landed on Bankrupt");
			System.out.println(" ");

			if (playerTurn == 1) {
				
				player1total = 0;
				
			}
			
			if (playerTurn == 2) {
				
				player2total = 0;
				
			}
			
			if (playerTurn == 3) {
				
				player3total = 0;
				
			}
			
			System.out.println("Your total has been reduced to 0");
			System.out.println(" ");
			System.out.println("Since you landed on Bankrupt, play passes to the next player");
			System.out.println(" ");
			playerTurn = playerTurn + 1;
			Wheel.spinWheel();
		}
		
		// If the result is 0 to 19, print out the amount from the array (e.g. 200, 400, etc.)
		else {
									
			// Tell the player the amount the wheel landed on
			System.out.println("The wheel landed on " + wheelAmounts[spinResult]);
			System.out.println(" ");
			roundAmount = wheelAmounts[spinResult];
			
			Phrase.guessLetter();
			
		}
	
	}
	
}
