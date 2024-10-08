package com.mycompany.app.Reusing_Classes.InterfacesExercise23;
import static org.greggordon.tools.Print.*;

class A {
	static int j = printInit("A.j initialized");
	static int printInit(String s) {
		println(s);
		return 1;
	}
	A() { println("A() constructor"); }	
} 

class B extends A {
	static int k = printInit("B.k initialized");
	B() { println("B() constructor"); }	
}
	
class C {
	static int n = printInitC("C.n initialized");
	static A a = new A();	
	C() { println("C() constructor"); }
	static int printInitC(String s) {
		println(s);
		return 1;
	}
}

class D {
	D() { println("D() constructor"); }
}

public class LoadClass extends B {
	static int i = printInit("LoadClass.i initialized");
	LoadClass() { println("LoadClass() constructor"); }
	public static void main(String[] args) {
		// accessing static main causes loading (and initialization)
		// of A, B, & LoadClass
		println("hi");
		// call constructors from loaded classes:
		LoadClass lc = new LoadClass();
		// call to static field loads & initializes C:
		println(C.a);
		// call to constructor loads D:
		D d = new D();
	}
}
