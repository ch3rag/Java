import java.util.Scanner;

public class Analysis {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int pass = 0;
		int fail = 0;
		int studentCounter = 0;
		while (studentCounter < 10) {
			System.out.print("Enter Result (1 = Pass, 2 = Fail): ");
			int result = input.nextInt();

			if (result == 1) {
				pass = pass + 1;
			} else {
				fail = fail + 1;
			}

			studentCounter = studentCounter + 1;
		}

		System.out.printf("Passed: %d%nFailed: %d%n", pass, fail);
		if (pass > 8) {
			System.out.println("Bonus To Instructor!");
		}
		input.close();
	}
}