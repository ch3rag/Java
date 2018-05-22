public class Person { //A file can have at most one public class
	private String name = "Unknown"; //Default Values
	private int    age  = 0;
	private char gender = 'M';
	private boolean alive = true;

	public Person(String name, int age, char gender, boolean alive) {
		this.name = name;
		this.age  = age;
		this.gender = gender;
		this.alive  = alive;
	}

	public Person(String name, int age) { //Constructor Overloading
		this.name = name;
		this.age  = age;
	}

	public Person(String name, int age, char gender) {
		this(name,age);
		this.gender = gender;
	}

	public String toString() {
		return ("My Name is " + name + ", my age is " + age + ", I'm " + ((gender == 'M')? "Male":"Female") + ", and I'm " + ((alive == true)? "Alive" : "Dead")); 
	}


	public static void main(String args[]) {
		Person David = new Person("David" , 18 , 'M', true);
		System.out.println(David.toString());
	}
}
