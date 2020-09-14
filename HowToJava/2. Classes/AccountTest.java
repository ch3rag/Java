import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		Account acc1 = new Account("Jane Green", 50.00);
		Account acc2 = new Account("John Blue", -7.53);
		DisplayBalance(acc1);
		DisplayBalance(acc2);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Deposit Amount For Account 1: ");
		double depositAmount = input.nextDouble();
		System.out.printf("%nAdding %.2f To Account 1 Balance%n%n", depositAmount);
		acc1.deposit(depositAmount);
		System.out.print("Enter Deposit Amount For Account 2: ");
		depositAmount = input.nextDouble();
		System.out.printf("%nAdding %.2f To Account 2 Balance%n%n", depositAmount);
		acc2.deposit(depositAmount);

		DisplayBalance(acc1);
		DisplayBalance(acc2);
	}

	void DisplayBalance(Account acc) {
		System.out.printf("%s Balance: $%.2f%n", acc.getName(), acc.getBalance());
	}
}