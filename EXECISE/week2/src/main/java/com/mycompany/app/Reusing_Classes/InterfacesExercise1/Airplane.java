package com.mycompany.app.Reusing_Classes.InterfacesExercise1;
import static org.greggordon.tools.Print.*;

class Engine {
	private String s;
	Engine() {
		println("Engine()");
		s = "Constructed";
	}
	public String toString() { return s; }
}

public class Airplane {
	private String fuselage, wings, tail;
	private Engine e;
	public Airplane() {
		println("Inside Airplane()");
		fuselage = "Body";
		wings = "Airfoils";
		tail = "Empennage";				
	}
	public String toString() { 
		if(e == null) // lazy (delayed) initialization:
			e = new Engine();
		return "fuselage = " + fuselage + ", " +
			"wings = " + wings + ", " +
			"tail = " + tail + ", " +
			"Engine = " + e;
	}
	public static void main(String[] args) {
		Airplane N1234 = new Airplane();
		print(N1234);
	}
}
