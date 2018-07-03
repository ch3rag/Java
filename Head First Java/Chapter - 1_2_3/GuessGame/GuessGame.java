public class GuessGame {
	Player p1;
	Player p2;
	Player p3;

	public void startGame() {
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();

		int guessP1 = 0;
		int guessP2 = 0;
		int guessP3 = 0;

		boolean isP1Right = false;
		boolean isP2Right = false;
		boolean isP3Right = false;

		int targetNumber = (int) (Math.random() * 10);

		System.out.println("I'm thinking of a number between 0 and 9..");

		while(true) {
			
			System.out.println("Number to guess is : " + targetNumber);

			p1.guess();
			p2.guess();
			p3.guess();

			guessP1 = p1.number;
			guessP2 = p2.number;
			guessP3 = p3.number;

			System.out.println("Player one guessed : " + guessP1);
			System.out.println("Player two guessed : " + guessP2);
			System.out.println("Player three guessed : " + guessP3);
			

			if(guessP1 == targetNumber) {
				isP1Right = true;
			}

			if(guessP2 == targetNumber) {
				isP2Right = true;
			}

			if(guessP3 == targetNumber) {
				isP3Right = true;
			}

			if(isP1Right || isP2Right || isP3Right) {
				
				System.out.println("We have a winner!");
				System.out.println("Player one got is right? : " + isP1Right);
				System.out.println("Player two got is right? : " + isP2Right);
				System.out.println("Player three got is right? : " + isP3Right);
				System.out.println("Game Over!");
				break;
			} else {
				System.out.println("Players will have to try again");
			}
		}
	}
}
