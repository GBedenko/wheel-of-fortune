/** 
 * This is the Phrase class for the Wheel of Fortune game.
 * 
 * This is where the player guesses letters for the phrase.
 * It will calculate how much they scored and add it to their total.
 * 
 * It checks whether the letter they guess is in the phrase.
 * It checks whether the letter has already been guessed.
 * It checks whether they guessed a vowel, and takes 250 from their total.
 * It checks whether they have completed the phrase.
 *  
 * @version 1.0
 * @author Genaro Bedenko
 */

import java.util.*;
import java.io.*;

public class Phrase extends Game {
	
	// guessLetter method allows the user to guess a letter after they have used the wheel
	public static void guessLetter() {
		
		// Show the user the current revealed phrase
		System.out.println("Here is the current phrase: " + shownPhrase);
		System.out.println(" ");
		
		// Allow the user to guess a letter for the phrase
		System.out.println("Please enter your guess for the letter:");
		System.out.println(" ");
			
		// Define variable for user's guess
		String guessInput;		
		
		// Take the user's input
		Scanner scan = new Scanner(System.in);
									
		// Save the user's input to a variable
		guessInput = scan.nextLine();
		
		// Convert the input into a capital letter
		guessInput = guessInput.toUpperCase();
				
		// Save the first letter of the user's guess to a char
		char guessLetter = guessInput.charAt(0);
				
		// Show the player their guess
		System.out.println("Your guess is the letter " + guessLetter);
		System.out.println(" ");
		
		// Check if the letter guessed has already been guessed
		for (int y = 0; y < guesses.length(); y++) {
			
			if (guessLetter == guesses.charAt(y)) {
								
				System.out.println("This letter has already been guessed, try a different letter");
				System.out.println(" ");
				Phrase.guessLetter();
						
			}
								
		}
		
		// Declare variable for amount of times letter is in phrase
		int count = 0;
		
		// Check each character in the phrase		
		for (int x = 0; x < phrase.length(); x++) {
			
			if (guessLetter == phrase.charAt(x)) {
								
				shownPhrase.setCharAt(x, guessLetter);	
				count++;
						
			}
								
		}
		
		// Show the user if guessed letter was in phrase and show them the phrase with letters filled in
		System.out.println("Your letter " + guessLetter + " was in the phrase " + count + " time(s)");
		System.out.println(" ");
		System.out.println(shownPhrase);
		System.out.println(" ");
				
		// Work out the winnings for their guess based on how many times it was in the phrase
		int winnings = count * roundAmount;
		
		// Add this guess's winnings to their overall total for the game
		// Determine whose turn it is so the winnings is added to the correct total
		if (playerTurn == 1) {
				player1total = winnings + player1total;
		}
		if (playerTurn == 2) {
			player2total = winnings + player2total;
		}
		if (playerTurn == 3) {
			player3total = winnings + player3total;
		}
		
		// Tell the user their current total
		// Determine whose turn it is so it tells them the correct total
		if (playerTurn == 1) {
			
			System.out.println("Your total is now " + player1total);
			System.out.println(" ");			
		}
		if (playerTurn == 2) {
			
			System.out.println("Your total is now " + player2total);
			System.out.println(" ");			
		}
		if (playerTurn == 3) {
			
			System.out.println("Your total is now " + player3total);
			System.out.println(" ");			
		}
		
		// Check if the guessed letter was a vowel. If it is deduct 250 from their total
		if ((guessLetter == 'A') || (guessLetter == 'E')  || (guessLetter == 'I') || (guessLetter == 'O') || (guessLetter =='U')) {
			
			System.out.println("However your last guess was a vowel. So 250 points will be taken away from your total.");
			System.out.println(" ");
			
			// Determine whose turn it is so it deducts the points from the correct total
			// If the player's total is less than 250, reduce the total to zero instead
			if (playerTurn == 1) {
				
				if (player1total >= 250) {
					
					player1total = player1total - 250;
				}
				else {
					
					System.out.println("Your current total is already less than 250, therefore your total has been reduced to zero.");
					System.out.println(" ");
					player1total = 0;
				}
				
				System.out.println("Your total is now " + player1total);
				System.out.println(" ");
			}	
			
			if (playerTurn == 2) {
				
				if (player2total >= 250) {
					
					player2total = player2total - 250;
				}
				else {
					
					System.out.println("Your current total is already less than 250, therefore your total has been reduced to zero.");
					System.out.println(" ");
					player2total = 0;
				}
				
				System.out.println("Your total is now " + player2total);
				System.out.println(" ");
			}
			
			if (playerTurn == 3) {
				
				if (player3total >= 250) {
					
					player3total = player3total - 250;
				}
				else {
					
					System.out.println("Your current total is already less than 250, therefore your total has been reduced to zero.");
					System.out.println(" ");
					player3total = 0;
				}
				
				System.out.println("Your total is now " + player3total);
				System.out.println(" ");
			}
		}
		
		// If the letter wasn't in the phrase, pass to the next player
		if (count == 0) {
			
			System.out.println("Your guess was not in the phrase, play passes to the next player");
			System.out.println(" ");
			playerTurn = playerTurn + 1;
		}
		
		// Check whether the phrase has been completed
		if (shownPhrase.toString().equals("E X A M P L E / P H R A S E ")) {
			
			// Determine whose turn it is so it tells the correct player that won, and that player's total
			if (playerTurn == 1) {
			
				System.out.println("You have completed the phrase! You won " + player1total + "!");
				System.out.println(" ");
				Game.endGame();				
			}
			
			if (playerTurn == 2) {
				
				System.out.println("You have completed the phrase! You won " + player2total + "!");
				System.out.println(" ");
				Game.endGame();				
			}
			
			if (playerTurn == 3) {
				
				System.out.println("You have completed the phrase! You won " + player3total + "!");
				System.out.println(" ");
				Game.endGame();				
			}
			
		}
		
		// After a guess has been made, add it to guesses, then spin wheel again
		guesses = guesses + guessLetter;
		Wheel.spinWheel();
	}
	
}
