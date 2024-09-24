package ch06ex06;
import static ptmoskal.Print.*;

class chang {
	protected int i = 128;
	protected String s = "hello";
}

public class ClassB {
	public static void changeFields(chang object, int i, String s) {
		object.i = i;
		object.s = s;
	}
	public static void main(String[] args) {
		chang objA = new chang();
		print("objA.i = " + objA.i + ", objA.s = " + objA.s);
		ClassB.changeFields(objA, 256, "goodbye");
		print("objA.i = " + objA.i + ", objA.s = " + objA.s);
	}
}