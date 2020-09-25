package hangman2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	
	String hiddenWord;
	StringBuilder currentGuess;
	ArrayList<Character> guessDatabase = new ArrayList<>();
	
	int maxTries= 7;
	int currentTry= 0;
	
	ArrayList <String> dictionary = new ArrayList <>();
	private static FileReader fileReader;
	private static BufferedReader bufferedFileReader;
	
	
	public Hangman() throws IOException{
		// Constructor
		initializeStreams(); 
		hiddenWord = pickWord();
		currentGuess = initializeCurrentGuess();
	}


	
	// Reading the txt file
	
	private void initializeStreams() throws IOException {
		
		try {
			File inFile = new File("dictionary.txt");
			fileReader = new FileReader(inFile);
			bufferedFileReader = new BufferedReader(fileReader);
			String currentLine = bufferedFileReader.readLine();
			while (currentLine != null) {
			      dictionary.add(currentLine);
			      currentLine = bufferedFileReader.readLine();
			
			}
			bufferedFileReader.close();
			fileReader.close();
		}catch (IOException e) {
			System.out.println(" Stream not found!");
		}
	}

	
	// Pick the random word from dictionary
	
	
	public String pickWord() {
		Random random =new Random();
		int wordIndex = Math.abs(random.nextInt())% dictionary.size();
		return dictionary.get(wordIndex);
	}
	
	
	// Hide the chosen word
	
	public StringBuilder initializeCurrentGuess() {
		StringBuilder current = new StringBuilder();
		for (int i = 0; i<hiddenWord.length()*2 ; i++) {
			if (i% 2 == 0) {
				current.append("_");
			}else {
				current.append(" ");
			}
		}
		return current;
	}   
	
	
	// Show the chosen word
	
	public String getCurrentGuess() {
		return"Current Guess:" + currentGuess.toString();
	}
	
	
	
	// Determine game over and print appropriate message
	public boolean gameOver() {
		if (winning()) {
			System.out.println("You Won!");
			return true;
			}else if (loosing()) {
				System.out.println(" You lost!  "+" the word was " +" "+ hiddenWord);
				return true;
			}
		 return false;
	}
	
	
	
	// Boolean condition for winning game
	public boolean winning() {
		String guess = getGuessedForm();
		return guess.equals(hiddenWord);
	}
	
	
	// Boolean condition for loosing the game
	public boolean loosing() {
		return currentTry>= maxTries;
	}
	
	
	
	
	public String getGuessedForm() {
		String guess = currentGuess.toString();
		return guess.replace(" ", "");
	}
	
	
	
	// If letter already contained in the database alreadyEnterned
	public boolean alreadyEntered(char guess) {
		return guessDatabase.contains(guess);
	}
	
	
	
	// Check to see if the user guess matches the chosen word
	public boolean playGuess (char guess) {

		boolean isItAGoodGuess = false;
		for (int i = 0; i<hiddenWord.length(); i++)
		{
			if (hiddenWord.charAt(i)== guess) {
				currentGuess.setCharAt(i*2, guess);
				isItAGoodGuess = true;
				guessDatabase.add(guess);
			}
		}
		if (!isItAGoodGuess) {
			currentTry++;
		}
		return isItAGoodGuess;
		
		
	}
	
	// Draw hangman using the switch draw methods
	
	public String drawHangman() {
		switch(currentTry) {
		case 0: return start();
		case 1: return head();
		case 2: return body();
		case 3: return arm1();
		case 4: return arm2();
		case 5: return legs();
		default: return end();
		
		}
	}
	
	
 public String end2() {
	 
	 return  " - - - - -\n" +
             "|        |\n" +
             "|        O\n" +
             "|      / | \\ \n" +
             "|        |\n" +
             "|       / \\ \n" +
             "|\n" +
             "|\n";
}
	 

	private String end() {
	 return       " - - - - -\n" +
                  "|        |\n" +
                  "|        O\n" +
                  "|      / | \\ \n" +
                  "|        |\n" +
                  "|       / \\ \n" +
                  "|\n" +
                  "|\n";
	}


	private String legs() {
	 return       " - - - - -\n" +
                  "|        |\n" +
                  "|        O\n" +
                  "|      / | \\ \n" +
                  "|        |\n" +
                  "|         \\ \n" +
                  "|\n" +
                  "|\n";
	}


	private String arm2() {
	return       " - - - - -\n" +
                 "|        |\n" +
                 "|        O\n" +
                 "|      / | \\ \n" +
                 "|        |\n" +
                 "|\n" +
                 "|\n" +
                 "|\n";
	}


	private String arm1() {
	 return      " - - - - -\n" +
                 "|        |\n" +
                 "|        O\n" +
                 "|      / | \n"+
                 "|        |\n" +
                 "|\n" +
                 "|\n" +
                 "|\n";
	}


	private String body() {
	return	     " - - - - -\n" +
                 "|        |\n" +
                 "|        O\n" +
                 "|        |\n" +
                 "|        |\n" +
                 "|\n" +
                 "|\n" +
                 "|\n";
	}


	private String head() {
	return       " - - - - -\n" +
                 "|        |\n" +
                 "|        O\n" +
                 "|\n" +
                 "|\n" +
                 "|\n" +
                 "|\n" +
                 "|\n";
		
	}


	private String start() {
     return	     " - - - - -\n" +
                 "|        |\n" +
                 "|\n" +
                 "|\n" +
                 "|\n" +
                 "|\n" +
                 "|\n" +
                 "|\n";
	}

	
}












