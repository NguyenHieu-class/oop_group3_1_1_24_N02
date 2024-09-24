package com.mycompany.app.Reusing_Classes.InterfacesExercise8;
import static org.greggordon.tools.Print.*;

class A { 
	A(char c, int i) { println("A(char, int)");} 
}

class Ex8 extends A { 
	private char c;
	private int i;
	Ex8() { 
		super('z', 3);
		println("Ex8()"); 
	} 
	Ex8(char a, int j) { 	
		super(a, j); 
		c = a;
		i = j;
		println("Ex8(char,int)");
	}
	public static void main(String[] args) {
		Ex8 ex1 = new Ex8();
		Ex8 ex2 = new Ex8('b', 2); 
	}
}
