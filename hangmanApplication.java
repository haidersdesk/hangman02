package hangman2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class hangmanApplication {

	public static void main(String[] args) throws IOException {
  
		boolean gameOn = true;
		while (gameOn) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" :::::::::: Welcome to Hangman :::::::::");
		System.out.println();

		System.out.println(" Do you want to guess the letter: " + " L ");
		System.out.println(" Do you want to guess the Whole Word: " + " W ");
		

		String menu = "";
		menu = Character.toString(sc.nextLine().toUpperCase().charAt(0));

		switch (menu) {
		case "L":

			boolean gameOn1 = true;
			while (gameOn1) {

				System.out.println("Enter a letter to Start");
				Hangman game = new Hangman();

				do {
					System.out.println();
					System.out.println(game.drawHangman());
					System.out.println();
					System.out.println(game.getCurrentGuess());
					System.out.println(game.hiddenWord);
					System.out.println();
					System.out.println("Game Status : " +  " You have used " +game.currentTry +" "+ "guesses");

					// Get the guess
					System.out.println("Enter a letter to start");
					char guess = (sc.next().toLowerCase()).charAt(0);
					System.out.println();

					// Check if the character is guessed already

					while (game.alreadyEntered(guess)) {
						System.out.println("You have already guessed this letter");
						guess = (sc.next().toLowerCase()).charAt(0);
					}

					// Play the guess
					if (game.playGuess(guess)) {
						System.out.println("Great guess!! ");
					} else {
						System.out.println("unfortunate try! You used up your 7 tries Sorry");

					}
				} while (!game.gameOver());// keep playing until game is over

				System.out.println();
				System.out.println("  Play again ?  Y  ");
				System.out.println("  Quit game ?  Q  ");
				System.out.println("  Guess the word?  W  ");
				
				Character replyY = (sc.next().toUpperCase().charAt(0));
				gameOn1= false;
				gameOn = (replyY == 'Y');
			}

			
		case "W":
			
			boolean gameOn2 = true;
			while (gameOn2) {
			System.out.println("Enter the whole word please");
			Hangman game2 = new Hangman();

			
				System.out.println();
				System.out.println(game2.end2());
				System.out.println();
				System.out.println(game2.getCurrentGuess());
				System.out.println(game2.hiddenWord);
				
				
				
				// Get the guess
				System.out.print("Enter your word: ");
				String guessWord = (sc.next().toLowerCase());
				System.out.println();
				if (guessWord.equals(game2.hiddenWord)) {
					System.out.println(" AMAZING! You WON ");
					gameOn2 =false;
				} else {
					System.out.println("Sorry You guessed it wrong");
					System.out.println("The word was: " + " "+ game2.hiddenWord);
					System.out.println("  Play again ?  Y  ");
					System.out.println("  Quit game ?  Q  ");
					Character reply = (sc.next().toUpperCase().charAt(0));
					gameOn2 = (reply == 'Y');
					gameOn2 =true;

				}
			}	
				
			default :
				
				
						
						System.out.println("  enter the correct choice please  ");
						gameOn=true;
						
					}
			}
		
			
	}	
	

}
