import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class ArrayListEx {

	public static void main(String args[]) {

		ArrayList myArrayList;

		myArrayList = new ArrayList();

		//Type Specific ArrayList

		ArrayList<String> myStringArrayList = new ArrayList<String>();

		myStringArrayList.add("Hello");
		myStringArrayList.add("There");
		myStringArrayList.add("Java");
		myStringArrayList.add("Programmer");

		for(int i = 0 ; i < myStringArrayList.size() ; i++) {

			System.out.println(myStringArrayList.get(i));
		}

		//Changing Stored Values

		myStringArrayList.set(2, "Computer");

		System.out.println(myStringArrayList);
		
		//Removing items

		//myStringArrayList.remove(2);

		//myStringArrayList.removeRange(1,3);

		//Iterators

		Iterator myStringArrayListIterator = myStringArrayList.iterator();

		while (myStringArrayListIterator.hasNext()) { //Still Items Left In List
			System.out.println(myStringArrayListIterator.next());
		}

		//Copying All Items To Other List

		ArrayList copyList = new ArrayList();

		copyList.addAll(myStringArrayList);

		System.out.println(copyList);	

		//Contains

		if(myStringArrayList.contains("Computer")) {
			System.out.println("Found!");
		} else {
			System.out.println("Not Found!");
		}

		if(myStringArrayList.containsAll(copyList)) {
			System.out.println("myStringArrayList Contains copyList!");
		} else {
			System.out.println("Does not contain!");
		}	

		// ArrayList.clear() ==> Deletes All The Items From ArrayList
		// ArrayList.isEmpty() ==> Checks if an arraylist is empty

		//Array Of Generic Object

		Object[] words = new Object[4];

		words = myStringArrayList.toArray();

		System.out.println(Arrays.toString(words));

	}
}
