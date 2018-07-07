class StaticFinalTestDrive {
	public static void main(String[] args) {

		MyClass obj = new MyClass();

		int twoSquared = MyClass.square(2);
		System.out.println(twoSquared);

	}
}

class MyClass {
	static int instanceCount = 0;
	static int myVar;
	static final int myConstant = 0;
	//Or
	static final int myConstantTwo;
	//Then initailize in static block

	static {
		myConstantTwo = 5;
		myVar = 99;
	}

	MyClass() {
		instanceCount++;
		System.out.println("Number of instances : " + instanceCount);
	}

	static int square(int num) {
		return num * num;
	}
}
