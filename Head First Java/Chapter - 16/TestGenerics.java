import java.util.ArrayList;

class Animal {

	public void eat() {
		System.out.println("Animal is eating");
	}

}


class Dog extends Animal {

	public void bark() {
		System.out.println("Woof!");
	}

}

class Cat extends Animal {

	public void meow() {
		System.out.println("meow");
	}

}

public class TestGenerics {

	public static void main(String[] args) {

		Animal[] myAnimals = {new Dog(), new Cat(), new Cat(), new Dog()};
		Dog[] myDogs = {new Dog(), new Dog()};

		takeAnimal(myAnimals); //LEGAL
		takeAnimal(myDogs); //LEGAL
		//SINCE ARRAYS ARE OF FIXED SIZE, PASSING THEM INTO A POLYMORPHIC FUNCTION IS LEGAL SINCE WE CANNOT ADD A NEW CAT INTO A DOG ARRAY

		ArrayList <Animal> myAnimalsArrayList = new ArrayList <Animal> ();
		myAnimalsArrayList.add(new Cat());
		myAnimalsArrayList.add(new Dog());
		myAnimalsArrayList.add(new Dog());

		ArrayList <Dog> myDogsArrayList = new ArrayList <Dog>();
		myDogsArrayList.add(new Dog());
		myDogsArrayList.add(new Dog());

		takeAnimal(myAnimalsArrayList); //LEGAL
		
		//takeAnimal(myDogsArrayList); 
		//ILLEGAL SINCE MAYBE SOMEONE COULD ADD A CAT INTO A DOG ARRAYLIST!
		

		// NOW USING A GENERIC FUNCTION takeGenericAnimal()

		takeGenericAnimal(myAnimalsArrayList);
		takeGenericAnimal(myDogsArrayList);

	} 

	public static void takeAnimal(Animal[] animals) {
		for(Animal a : animals) {
			a.eat();
		}
	}

	public static void takeAnimal(ArrayList <Animal> animals) {
		for(Animal a : animals) {
			a.eat();
		}
	}

	// public static void takeGenericAnimal(ArrayList <? extends Animal> animals) {
	public static <T extends Animal> void takeGenericAnimal(ArrayList <T> animals) {
		//WE CAN'T PERFORM ADDITION IN THE ARRAYLIST, AND THEY ARE CHECKED AT COMPILE TIME
		for(Animal a : animals) {
			a.eat();
		}
		//THIS WON'T COMPILE
		//animals.add(new Cat());
	}
}
