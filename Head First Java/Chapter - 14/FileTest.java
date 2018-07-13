import java.io.*;

public class FileTest {

	public static void main(String[] args) {

		File myDir = new File("data");
		myDir.mkdir();

		// CREATE A DIRECTORY NAMED DATA

		System.out.println(myDir.isDirectory());

		//CHECK IF A FILE IS A DIRECTORY

		File file1 = new File("data/myFile1.txt");
		File file2 = new File("data/myFile2.txt");

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
			writer.write("Hello There!");
			writer.close();

			FileWriter fileWriter = new FileWriter(file2);
			fileWriter.write("This Is File2");
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		//LISTING FILES
		
		String[] files = myDir.list();

		for(String file : files) {
			System.out.println(file);
		}


		//READING
		try {
			String line = null;
			FileReader fileReader = new FileReader(file1);
			BufferedReader reader = new BufferedReader(fileReader);

			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println(myDir.delete());
		
		//DIRECTORY CONTAINS FILE SO IT CANNOT BE DELETED

		System.out.println(file1.delete());
		System.out.println(file2.delete());
		System.out.println(myDir.delete());
	}
}
