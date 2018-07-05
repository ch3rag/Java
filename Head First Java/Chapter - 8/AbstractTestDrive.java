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

	public void sleep() {
		System.out.println(getName() + " is Sleeping!");
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

		Dog myDog2 = new Dog();

		
		myDog.setName("Tommy");
		myCat.setName("Nancy");
		
		//Illegal!
		//myDog.sleep();
		//Since reference is Animal type, the methods defined in Animals call are allowed to be called

		myDog2.sleep();
		//Legal, since reference type is Dog
		
		myAnimals.add(myDog);
		myAnimals.add(myCat);

		for(Animal animal : myAnimals) {
			myVet.treatAnimal(animal);
		}

		//The Classes which doesn't explicitly extend any onther class inherits "Object" class

		//Some of its method include

		System.out.println(myDog.getClass());
		System.out.println(myDog.hashCode());
		System.out.println(myDog.toString());
		System.out.println(myDog.equals(myCat));
		System.out.println(myDog.equals(myDog2));

	}
}
