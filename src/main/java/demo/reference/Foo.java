package demo.reference;

/**
 * Created by leicheng on 16-9-19.
 */
public class Foo {

	private String attribute;

	Foo(String s) {

		this.attribute = s;

	}

	void setAttribute(String s) {

		this.attribute = s;

	}

	String getAttribute() {

		return this.attribute;

	}
}
