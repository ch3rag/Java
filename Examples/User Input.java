import java.util.Scanner;

public class MyClass {

	static Scanner myUserInput = new Scanner(System.in);

	public static void main(String args[]) {
		System.out.println("Input : ");

		if(myUserInput.hasNextInt()) { //hasInput checks whether the input is of type specified

			System.out.println("Integer");

			int myNum = myUserInput.nextInt();

		} else if(myUserInput.hasNextDouble()) {

			System.out.println("Double");

			double myDouble = myUserInput.nextDouble();

		} else if(myUserInput.hasNextBoolean()) {

			System.out.println("Boolean");

			boolean myBool = myUserInput.nextBoolean();

		} else if(myUserInput.hasNextLine()) {

			System.out.println("String");

			String myString = myUserInput.nextLine();
		}

 	}
}
