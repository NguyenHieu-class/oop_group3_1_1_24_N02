package com.mycompany.app.Reusing_Classes.InterfacesExercise7;
import static org.greggordon.tools.Print.*;

class A { 
	A(char c, int i) { println("A(char, int)");} 
}

class B extends A { 	
	B(String s, float f){
		super(' ', 0); 
		println("B(String, float)");
	} 
}

class C7 extends A { 
	private char c;
	private int i;
	C7(char a, int j) { 	
		super(a, j); 
		c = a;
		i = j;
	}
	B b = new B("hi", 1f); // will then construct another A and then a B
	public static void main(String[] args) {
		C7 c = new C7('b', 2); // will construct an A first
	}
}
