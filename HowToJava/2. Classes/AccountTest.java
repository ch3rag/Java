import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account myAccount = new Account("Jane Green");
		System.out.printf("Initial Name Is: %s%n%n", myAccount.getName());
		
		System.out.print("Please Enter The Name: ");
		String theName = input.nextLine();
		myAccount.setName(theName);
		System.out.println();
		System.out.printf("Name In Object myAccount Is: %s%n", myAccount.getName());
		input.close();
	}
}
