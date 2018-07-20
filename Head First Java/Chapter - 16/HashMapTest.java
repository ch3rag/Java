import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap <String, Integer> studentsId = new HashMap <String, Integer> ();

		studentsId.put("Chirag", 717042);
		studentsId.put("Prathmesh", 717041);
		studentsId.put("Abhay", 7170000);

		System.out.println(studentsId);
		System.out.println(studentsId.get("Chirag"));
		studentsId.remove("Abhay");
		System.out.println(studentsId);
		System.out.println(studentsId.values());

	}
}
