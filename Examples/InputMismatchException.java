import java.util.*;

public class InputMismatch {
	
	static Scanner myInput = new Scanner (System.in);

	public static void main(String args[]) {

	System.out.println("How Old Are You : ");
	int age = checkValidAge();
	if(age != 0) {
		System.out.println("You are " + age + " year old.");
	}
	}

	public static int checkValidAge() {

	try {
		return myInput.nextInt();
	} catch (InputMismatchException e) {
		System.out.println("Invalid Age!");
		System.out.println(e.getMessage()); //NULL
		System.out.println(e.toString());	
		e.printStackTrace();
		return 0;

	}
	}

}
