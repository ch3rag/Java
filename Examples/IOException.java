import java.io.*;

public class IOExcept {

	public static void main(String args[]){

		openAFile("Stuff.txt");

	}

	public static void openAFile(String filename) {
		try {
			FileInputStream file = new FileInputStream(filename);
		} 

		catch (FileNotFoundException e) { //Most Specific Exception;
			System.out.println("File Not Found!");
		}

		catch (IOException e) { //Less Specific Exception
			System.out.println("IO Error has occured!");
		} 

		catch(Exception e) { //Least Specific (Catches all Exceptions)
			System.out.println("An Unknown error has occured!");
		}

		finally { //Finally block will execute no matter what happened
			System.out.println("This gets executed no matter what.");
			//Used For Cleanup Purpose
		}

	}
}
