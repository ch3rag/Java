import java.util.ArrayList;
import java.io.*;

public class DotComBust {

	private GameHelper helper = new GameHelper();
	private ArrayList <DotCom> dotComList = new ArrayList <DotCom> ();
	private int numOfGuesses = 0;

	private void setupGame() {

		DotCom one = new DotCom();
		DotCom two = new DotCom();
		DotCom three = new DotCom();

		one.setName("Pets.com");
		two.setName("eToys.com");
		three.setName("Go2.com");

		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);

		System.out.println("Your goal is to sinl three dot coms!");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink the, all in the fewest number of gueses");

		for(DotCom dotComToSet : dotComList) {
			ArrayList <String> newLocation  = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {

		while(!dotComList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			if(userGuess.equals("exit")) break;
			checkUserGuess(userGuess);
		} 
		finishGame();
	}

	private void checkUserGuess(String guess) {
		numOfGuesses++;
		String result = "miss";
		for(DotCom dotComtoTest : dotComList) {
			result = dotComtoTest.checkYourself(guess);
			if(result.equals("hit")) {
				break;
			}
			if(result.equals("kill")) {
				dotComList.remove(dotComtoTest);
				break;
			}
		}
		System.out.println(result);
	}

	private void finishGame() {
		System.out.println("All Dot Coms are dead your stock is now worthless.");
		if(numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with you options.");
		}	
 	}

 	public static void main(String[] args) {

 		DotComBust game  = new DotComBust();
 		game.setupGame();
 		game.startPlaying();

 	}
}

class DotCom {

	private ArrayList <String> locationCells;
	private String name;

	public void setLocationCells(ArrayList <String> locations) {
		locationCells = locations;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String checkYourself(String userGuess) {
		String result = "miss";
		int index = locationCells.indexOf(userGuess);
		if(index >= 0) {
			locationCells.remove(index);
			if(locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Ouch! You sunk " + name + " :(");
			} else {
				result = "hit";
			}
		}
		return result;
	}
}

class GameHelper {

	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize   = 49;
	private int [] grid = new int [gridSize];
	private int comCount = 0;

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
		return inputLine.toLowerCase();
	}

	public ArrayList <String> placeDotCom (int comSize) {
		ArrayList <String> locations = new ArrayList <String> ();
		boolean success = false;
		int [] coords = new int [comSize];
		int attempts = 0;
		int increment;
		if(comCount % 2 == 0) {
			increment = 1;
		} else {
			increment = gridLength;
		}
		while(!success && attempts++ < 200) {
			int x = 0;
			success = true;
			int randomPoint = (int) (Math.random() * gridSize);
			while(success && x < comSize) {
				if((randomPoint >= gridSize) || ((randomPoint % gridLength == 0) && (x > 0)) || grid[randomPoint] == 1) {
					success = false;
					break;
				} else {
					coords[x++] = randomPoint;
					randomPoint += increment;
				}
			}
		}

		for(int point : coords) {
			grid[point] = 1;
			int alpha = point / gridLength;
			int number = point % gridLength;
			String aCoords = (alphabet.charAt(alpha) + Integer.toString(number));
			locations.add(aCoords);
		}

		comCount++;
		//System.out.println(locations);
		return locations;
	}
	
}
