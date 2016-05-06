/**
 * This is the main Game class for the Wheel of Fortune game
 * 
 * This class is where the variables for the game are stored.
 * 
 * This class will setup the game 
 * This class contains the rules if the player wants to read them before playing.
 * This class contains code for when the game ends to let them play again.
 * 
 * @version 1.0
 * @author Genaro Bedenko
 */

import java.util.*;

public class Game {
	
	// Declare the phrase for the game
	static String phrase = ("E X A M P L E / P H R A S E "); 
	
	// Declare the empty phrase
	static String revealedPhrase = ("_ _ _ _ _ _ _ / _ _ _ _ _ _ ");
	
	// Declare the phrase that will be changed as the players guess letters
	static StringBuilder shownPhrase = new StringBuilder("_ _ _ _ _ _ _ / _ _ _ _ _ _ ");
		
	// Declare the players starting totals	
	static int player1total = 0;
	static int player2total = 0;
	static int player3total = 0;
	
	// Variable for the current player
	static String currentPlayer;
	
	// Declare turn counter to record whose turn it is, starting at player 1
	static int playerTurn = 1;
	
	// Declare the amount for before a player wins or loses the amount
	static int roundAmount;
	
	// Declare a variable where guesses are stored so they cannot be guessed more than once
	static String guesses = ("");
	
	// Declare variables for players names
	static String player1name;

	static String player2name;

	static String player3name;
	
	// main method asks the user for an input to setup the game
	public static void main(String[] args) {
				
		// Allow the user to start a new game or see the rules	
		System.out.println("To start a New Game, enter 1:");
		System.out.println("To see How to Play, enter 2:");
		
		// Allow the user to start a new game
		int input;
		
		// Take the user's input
		Scanner scan = new Scanner(System.in);
									
		// Save the user's input to a variable
		input = scan.nextInt();
					
		if (input == 1) {
													
			Game.enterPlayers();
		}
		
		if (input == 2) {
			
			// Explain rules of the game
			System.out.println("This is a version of the gameshow Wheel of Fortune.");
			System.out.println(" ");
			System.out.println("This game supports 3 players");
			System.out.println(" ");
			System.out.println("In this game you need to:");
			System.out.println("Spin the wheel which will land on a random segment");
			System.out.println("Guess a letter that you think is in the phrase");
			System.out.println(" ");
			System.out.println("If the letter you guess is in the phrase, the amount multiplied by how many times it is in the phrase is added to your total");
			System.out.println("If the letter is not in the phrase, you do not win the money you landed on");
			System.out.println(" ");
			System.out.println("Play will pass on to the next player if you guess incorrectly");
			System.out.println(" ");
			System.out.println("Continue guessing letters until the phrase is complete");
			System.out.println("When the phrase is complete, the player who guesses the last letter wins their total");
			System.out.println(" ");
			System.out.println("Bankrupt will reduce a player's total to zero");
			System.out.println("You can enter vowels for your guess, but the player's total will be reduced by 250 points");
			System.out.println("If you enter a letter that has already been guessed, you will be asked to guess again");
			System.out.println(" ");
			Game.main(null);
		}
			
		else {
				
			Game.main(null);
		}
				
	}		
			
	public static void enterPlayers() {
					
			// Run the methods to enter the names for each player
			Player.enterPlayer1Name();
			Player.enterPlayer2Name();
			Player.enterPlayer3Name();
			
			// Show the players the phrase with empty spaces to show how long the phrase is
			System.out.println("The phrase for this game is:   " + revealedPhrase);
			System.out.println(" ");
			
			// Confirm that the game is ready to play and setup is complete
			System.out.println("New game is ready. Spin the Wheel!");
			System.out.println(" ");
			Wheel.spinWheel();		
		
	}	
	
	// endGame method is shown when the phrase is completed, it allows them to start a new game
	public static void endGame() {
		
		System.out.println("Thanks for playing!");
		System.out.println(" ");
		Game.main(null);	
	}
	
}
	
