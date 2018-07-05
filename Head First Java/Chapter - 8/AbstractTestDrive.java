import java.util.ArrayList;

abstract class Animal {

	private String name;

	//Name property is generic so we can define it in abstract class itself
	public void setName(String name) {
		this.name = name; 
	}

	public String getName() {
		return this.name;
	}

	//Since noise of each animal maybe different so we make it abstract 
	public abstract void makeNoise();

}

//Dog class inherit animal class so it "must" implement all the its abstract method
class Dog extends Animal { 

	public void makeNoise() {
		System.out.println("Woof!");
	}

}

class Cat extends Animal {

	public void makeNoise() {
		System.out.println("Meow!");
	}
}

class Vet {

	public void treatAnimal(Animal myAnimal)  {
		//Receives a generic Animal Object
		//Do all kind of stuff
		System.out.print(myAnimal.getName() + " says " );
		myAnimal.makeNoise();
	}

}


public class AbstractTestDrive {

	public static void main(String[] args) {
		
		ArrayList <Animal> myAnimals = new ArrayList <Animal> ();
		//Animal myAnimal = new Animal();  
		//This is illegal since abstract class can't be instantiated
		Vet myVet = new Vet();
		Animal myDog = new Dog();
		Animal myCat = new Cat();

		myDog.setName("Tommy");
		myCat.setName("Nancy");

		myAnimals.add(myDog);
		myAnimals.add(myCat);

		for(Animal animal : myAnimals) {
			myVet.treatAnimal(animal);
		}
	}
}
