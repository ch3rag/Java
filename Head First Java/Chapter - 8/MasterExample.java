import java.util.ArrayList;

interface Pet {
	void play();
	void beFriendly();

	// public abstract void play();
	// public abstract void beFriendly();
	// Interface Methods are implicitly defined as abstract and public
}

abstract class Animal {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public abstract void eat();
	public abstract void makeSound();
	public abstract void roam();

}

abstract class Canine extends Animal {
	
	private int stepSize = 10;
	
	public void roam() {
		System.out.println(getName() + " walks " + stepSize + " steps!");
	}
}

abstract class Feline extends Animal {

	public void eat() {
		System.out.println("Feline : " + getName() + " eats flesh!");
	}
}

class Dog extends Canine implements Pet {

	public void makeSound() {
		System.out.println(getName() + " says woof!");
	}

	public void eat() {
		System.out.println(getName() + " eats his favorite DogFood!");
	}

	public void play() {
		System.out.println(getName() + " plays with his owner!");
	}

	public void beFriendly() {
		System.out.println(getName() + " shows love to his owner!");
	}

}


class Wolf extends Canine {

	public void makeSound() {
		System.out.println(getName() + " howls!");
	}

	public void eat() {
		System.out.println(getName() + " eats flesh!");
	}

}


class Cat extends Feline implements Pet {

	private int stepSize = 3;

	public void makeSound() {
		System.out.println(getName() + " says meow!");
	}

	public void roam() {
		System.out.println(getName() + " walks " + stepSize + " steps!");
	}

	public void play() {
		System.out.println(getName() + " plays with his owner!");
	}

	public void beFriendly() {
		System.out.println(getName() + " shows love to his owner!");
	}
}

public class MasterExample {

	public static void main(String[] args) {

		ArrayList <Pet> pets = new ArrayList <Pet> ();

		Dog myDog = new Dog();
	
		Wolf myWolf = new Wolf();

		Cat myCat = new Cat();

		myDog.setName("Tommy");

		myWolf.setName("Wolfie");

		myCat.setName("Nancy");

		myDog.roam();
		myDog.eat();
		myDog.makeSound();

		myWolf.roam();
		myWolf.eat();
		myWolf.makeSound();

		myCat.roam();
		myCat.eat();
		myCat.makeSound();


		pets.add(myCat);
		pets.add(myDog);

		//Does Not Work!
		//pets.add(myWolf);

		for(Pet pet : pets) {
			playWithPet(pet);
		}



	}

	static void playWithPet(Pet myPet) {

		myPet.play();
		myPet.beFriendly();

	}
}
