import java.util.Arrays;

public class ArrayEx {
	public static void main(String args[]) {

		int[] myArray;

		myArray = new int[10];

		Arrays.fill(myArray, 123);

		for(int i = 0 ; i < myArray.length ; i++) {
			myArray[i] = i * 10;
		}

		for(int item : myArray) {
			System.out.println(item + " ");
		}

		String[] randomWords = {"hello", "bye", "there", "where", "home"};

		for(String word : randomWords) {

			System.out.println(word + " ");
		}

		//Copying an array

		int[] myNewArray = Arrays.copyOf(myArray, 5); //Copies first five elements
		int[] newArray   = Arrays.copyOfRange(myArray, 2, 7); //Copies elements from index 2 to 7

		for(int item : newArray) {
			System.out.println(item + " ");
		}

		System.out.println(Arrays.toString(myArray)); //Converts Array to a string

		//Generating an array of random numbers

		int[] randomNum = new int[10];

		for(int i = 0 ; i < randomNum.length ; i++) {
			randomNum[i] = (int) (Math.random() * 100); 
		}

		//Sorting An Array

		Arrays.sort(randomNum);

		System.out.println(Arrays.toString(randomNum));

		System.out.println(Arrays.binarySearch(myArray, 50));
		System.out.println(Arrays.binarySearch(myArray, 11));
		//Negative if not found else returns index




	}
}
