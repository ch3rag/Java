import java.io.*;

public class FileWriterTest {

	public static void main(String[] args) {

		String stringToWrite = "Hello, World!";

		try {
			FileWriter fw = new FileWriter("myFile.txt");
			fw.write(stringToWrite);
			fw.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
