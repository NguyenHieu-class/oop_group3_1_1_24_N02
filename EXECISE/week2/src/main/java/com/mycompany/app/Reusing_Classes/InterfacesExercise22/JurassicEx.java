package com.mycompany.app.Reusing_Classes.InterfacesExercise22;

class SmallBrain {} 

final class Dinosaur {
	SmallBrain x = new SmallBrain();
}

// class Further extends Dinosaur {} // error: cannot inherit from final Dinosaur

public class JurassicEx {
	public static void main(String[] args) {
		Dinosaur d = new Dinosaur();
	}
}
