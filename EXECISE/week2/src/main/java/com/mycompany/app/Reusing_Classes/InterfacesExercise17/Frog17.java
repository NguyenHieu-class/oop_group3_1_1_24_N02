package com.mycompany.app.Reusing_Classes.InterfacesExercise17;
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

public class Frog17 extends Amphibian {
	@Override protected void swim() {
		println("Frog swim");		
	}
	@Override protected void speak() {
		println("Frog speak");
	}
	@Override void eat() {
		println("Frog eat");
	}
	static void grow(Amphibian a) {
		println("Frog grow");
		a.eat();
	}
	public static void main(String[] args) {
		Frog17 f = new Frog17();
		// call overridden base-class methods:
		f.swim();
		f.speak();
		f.eat();
		// upcast Frog17 to Amphibian argument:
		f.grow(f);
		// upcast Frog17 to Amphibian and call Amphibian method:
		Amphibian.grow(f);
	}
}
