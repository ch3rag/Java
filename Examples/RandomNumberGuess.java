import java.util.Scanner;

public class RandomGuess {

	static Scanner myInput = new Scanner(System.in);
	static int randomNumber;

	public static void main(String args[]) {

		randomNumber = getRandomNumber();	
		int randomGuess  = 0;
		int userGuess;
		System.out.println("Random Number : " + randomNumber);
		while(randomGuess != -1) {
			System.out.println("Enter a number between 0 and 10 : ");
			userGuess = myInput.nextInt();
			randomGuess = checkGuess(userGuess);
		}
		System.out.println("Your guess is correct!");
	}

	public static int getRandomNumber() {
		return (int)(Math.random() * 11);
	}

	public static int checkGuess(int guess) {
		if(randomNumber == guess) {
			return -1;
		} else {
			return guess;
		}
	}
}
