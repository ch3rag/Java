import java.util.Scanner;

public class Comparision {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		System.out.print("Enter First Naumber: ");
		a = sc.nextInt();
		System.out.print("Enter Second Number: ");
		b = sc.nextInt();

		if (a == b) {
			System.out.printf("%d == %d%n", a, b);
		}

		if (a != b) {
			System.out.printf("%d != %d%n", a, b);
		}

		if (a > b) {
			System.out.printf("%d > %d%n", a, b);
		}

		if (a < b) {
			System.out.printf("%d < %d%n", a, b);
		}

		if (a >= b) {
			System.out.printf("%d >= %d%n", a, b);
		}

		if (a <= b) {
			System.out.printf("%d <= %d%n", a, b);
		}
		sc.close();
	}	
}
