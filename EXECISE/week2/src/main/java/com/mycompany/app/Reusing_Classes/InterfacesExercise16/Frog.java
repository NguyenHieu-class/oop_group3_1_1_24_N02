package com.mycompany.app.Reusing_Classes.InterfacesExercise16;
import static org.greggordon.tools.Print.*;

class Amphibian {
	protected void swim() {
		println("Amphibian swim");		
	}
	protected void speak() {
		println("Amphibian speak");
	}
	void eat() {
		println("Amphibian eat");
	}
	static void grow(Amphibian a) {
		println("Amphibian grow");
		a.eat();
	}
}

public class Frog extends Amphibian {
	public static void main(String[] args) {
		Frog f = new Frog();
		// call base-class methods:
		f.swim();
		f.speak();
		f.eat();
		// upcast Frog to Amphibian argument:
		Amphibian.grow(f);
	}
}
