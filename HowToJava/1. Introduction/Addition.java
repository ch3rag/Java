import java.util.Scanner;

public class Addition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int sum;

		System.out.print("Enter First Number: ");
		a = sc.nextInt();
		
		System.out.print("Enter Second Number: ");
		b = sc.nextInt();
		
		sum = a + b;

		System.out.printf("Sum: %d%n", sum);
		sc.close();
	}
}