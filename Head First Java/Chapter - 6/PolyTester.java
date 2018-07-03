class Appliance {
	void turnOn() {
		System.out.println("Appliance turned on!");
	}

	void turnOff() {
		System.out.println("Appliance turned off!");
	}
}

class Toaster extends Appliance {

	//This is not Overriding but Overloading
	void turnOn(int level) {
		System.out.println("Toaster turned on!");
	} 
	// Illegal to change privilages of overriden method!
	// private void turnOff() {
	// 	System.out.println("Toaster turned off!");
	// }

}

public class PolyTester {

	public static void main(String[] args) {
		Appliance a = new Toaster();
		a.turnOn();
		//Appliance turned on!
	}

}
