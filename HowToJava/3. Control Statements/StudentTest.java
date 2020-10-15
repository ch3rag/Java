public class StudentTest {
	public static void main(String[] args) {
		Student stu1 = new Student("Jane Green", 93.5);
		Student stu2 = new Student("John Blue", 72.75);

		System.out.printf("%s's letter grade is %s%n", stu1.getName(), stu1.getLetterGrade());
		System.out.printf("%s's letter grade is %s%n", stu2.getName(), stu2.getLetterGrade());

	}
	
}
