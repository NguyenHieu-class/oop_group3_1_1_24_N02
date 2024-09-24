package com.mycompany.app.Reusing_Classes.InterfacesExercise5;
import static org.greggordon.tools.Print.*;

class A { A(){ println("A()");} }

class B extends A { B(){ println("B()");} }

class C extends A { 
	B b = new B(); // will then construct another A and then a B
	public static void main(String[] args) {
		C c = new C(); // will construct an A first
	}
}
