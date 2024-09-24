package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise7.initialization;

class Aso {
	void bark() {System.out.println("woof");}
} 	

public class AutomaticConstructor {
	public static void main(String[] args) {
		Aso a = new Aso();
		a.bark();
	}
}
