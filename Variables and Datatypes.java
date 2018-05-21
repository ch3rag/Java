
class Datatypes {

	public static void main(String args[]) {

		byte myByte = 127;

		int myInt = 11234;

		short myShort = 1235;

		long myLong = 21334436546456L;

		float myFloat = 3.3432123F; //8 Places Precision

		double myDouble = 2.1234234534523423; //15 Places Precision

		boolean myBool = true; //or false

		String myString = "Welcome To Java!";

		char myChar = 65; // or 'A'


		//Maximum Values Of Data-types

		System.out.println("Max Int : " + Integer.MAX_VALUE);
		System.out.println("Max Byte : " + Byte.MAX_VALUE);
		System.out.println("Max Short  : " + Short.MAX_VALUE);
		System.out.println("Max Long : " + Long.MAX_VALUE);
		System.out.println("Max Float : " + Float.MAX_VALUE);
		System.out.println("Max Double : " + Double.MAX_VALUE);

		//MINIMUM VALUES Of Data-types

		System.out.println("Min Int : " + Integer.MIN_VALUE);
		System.out.println("Min Byte : " + Byte.MIN_VALUE);
		System.out.println("Min Short  : " + Short.MIN_VALUE);
		System.out.println("Min Long : " + Long.MIN_VALUE);
		System.out.println("Min Float : " + Float.MIN_VALUE);
		System.out.println("Min Double : " + Double.MIN_VALUE);

		//Casting

		myInt = (int) myFloat;

		System.out.println(myInt);

		//Parsing To String

		String myNum = Integer.toString(myInt);

		System.out.println(myNum);

		String myBoolString = Boolean.toString(myBool);

		System.out.println(myBoolString);

		//String to Other Types

		myNum = "13432";

		myInt = Integer.parseInt(myNum);

		System.out.println(myInt);



	}
}

