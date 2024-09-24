package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise15;

class Tester {
	String s;
	{
		s = "Initializing string in Tester";
		System.out.println(s);
	}
	Tester() {
		System.out.println("Tester()");
	}
}

public class InstanceClauseTest {
	public static void main(String[] args) {
		new Tester();				
	}
}
