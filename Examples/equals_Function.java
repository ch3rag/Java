import java.util.Scanner;

public class YorN {
	static Scanner myInput = new Scanner(System.in);
	public static void main(String args[]) {
		String yesOrNo = "y";

		while(yesOrNo.equalsIgnoreCase("y")) { 
      //equals is case Sensitive whereas equalsIgnoreCase not
			System.out.println("Hi!");
			System.out.println("Continue? Y or N : ");
			yesOrNo = myInput.nextLine();
		}
	}
}
