import java.io.*;

class GameHelper {

	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length() == 0) {
				return null;
			}
			
		} catch(IOException e) {
				System.out.println("IOException: " + e);
		}

		return inputLine;
	}
}


class SimpleDotCom {

	private int[] locationCells;
	private int numHits = 0;

	public void setLocationCells(int[] locations) {
		locationCells = locations;
	}

	public String checkYourself(String userGuess) {
		int guess = Integer.parseInt(userGuess);
		String result = "miss";
		for(int cell : locationCells) {
			if(guess == cell) {
				result = "hit";
				numHits++;
				break;
			}
		}

		if(numHits == locationCells.length) {
			result = "kill";
		}

		System.out.println(result);
		return result;
	} 


}

public class SimpleDotComTestDrive {

	public static void main(String[] args) {

		GameHelper helper = new GameHelper();
		SimpleDotCom dot = new SimpleDotCom();
		int numOfGuesses = 0;
		String result;
		boolean isAlive = true;
		int randomNum = (int)(Math.random() * 5);
		int[] locationCells = {randomNum, randomNum + 1, randomNum + 2};
		dot.setLocationCells(locationCells);

		while(isAlive) {
			String guess = helper.getUserInput("enter a number");
			numOfGuesses++;
			result = dot.checkYourself(guess);
			if(result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}
}
