

public class Pi {

	public static void  main(String args[]) {
		double j = 3;
		double Pi = 4;

		//Pi = 4 - 4/3 + 4/5 - 4/7 + 4/9.....

		while (j < 10000) {
			Pi = Pi - (4/j) + (4/(j+2));
			j += 4;
		}
		
		System.out.println("Pi : " + Pi);
		System.out.println("Real Pi : " + Math.PI);
	}
}
