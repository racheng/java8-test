package demo.reference;

/**
 * Created by leicheng on 16-9-19.
 */
public class Main {
	public static void modifyReference(Foo cRef) {

		cRef.setAttribute("c"); // line DDD

	}

	public static void changeReference(Foo aRef) {

		Foo bRef = new Foo("b"); // line FFF

		aRef = bRef;   // line EEE

	}

	public static void main(String[] args) {

		Foo fooRef = new Foo("a"); // line AAA

		changeReference(fooRef); // line BBB

		System.out.println(fooRef.getAttribute()); // 输出 a

		modifyReference(fooRef); // line CCC

		System.out.println(fooRef.getAttribute()); // 输出 c

	}

}
