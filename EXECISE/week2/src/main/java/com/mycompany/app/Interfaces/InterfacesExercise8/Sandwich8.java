package com.mycompany.app.Interfaces.InterfacesExercise8;

import static net.mindview.util.Print.*;

interface FastFood {
	void cheeseburger();
	void fries();
	void softDrink();
}

class Meal {
	Meal() { print("Meal()"); } 
}

class Bread {
	Bread() { print("Bread()"); } 
}

class Cheese {
	Cheese() { print("Cheese()"); } 
}

class Lettuce {
	Lettuce() { print("Lettuce()"); } 
}

class Lunch extends Meal {
	Lunch() { print("Lunch()"); } 
}

class PortableLunch extends Lunch {
	PortableLunch() { print("PortableLunch()"); } 
}	

public class Sandwich8 extends PortableLunch implements FastFood {
	private Bread b = new Bread();
	private Cheese c = new Cheese();
	private Lunch l = new Lunch();
	public Sandwich8() { print("Sandwich8()"); }
	public void cheeseburger() {
		print("Cheeseburger");
	}
	public void fries() {
		print("Fries");
	}
	public void softDrink(){
		print("Soft Drink");
	}
	public static void main(String[] args) {
		Sandwich8 s = new Sandwich8();
		s.cheeseburger();
		s.fries();
		s.softDrink();
		
	} 
}
