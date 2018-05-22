import java.io.*;

public class ThrowAndCatch {
	public static void main(String args[]) {

		try {
			openAFile("Sumstuff.txt");
		} catch(IOException e) {
			System.out.println("An IO error has occured!");
		}
	}

	public static void openAFile (String filename) throws IOException, FileNotFoundException {
		FileInputStream file = new FileInputStream(filename);
	} 

}
