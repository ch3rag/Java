public class Exceptions {
	public static void main(String args[]) {
		divideByZero(2);
	}

	public static void divideByZero(int num) {

		try {

			System.out.println(num/0);

		} catch(ArithmeticException e) { //e = Exception Object
			System.out.println("You Can't Do That!");
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}
