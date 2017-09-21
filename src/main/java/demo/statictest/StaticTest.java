package demo.statictest;

/**
 * Created by leicheng on 17-5-4.
 */
public class StaticTest {

	public static void main(String[] args) {
		System.out.println(Student.age);

		Student test1= new Student();
		System.out.println(Student.age);

		System.out.println(test1.age);
		Student test2 = new Student(4);

		System.out.println(test2.age);
		System.out.println(test1.age);
		System.out.println(Student.age);

	}
}
