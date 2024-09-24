package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise4.initialization;

class Kabayo2 {
	Kabayo2() {
		System.out.println("isa lang kabayo");
	}
	Kabayo2(String s) {
		System.out.println(s);
	}	
} 

public class DefaultConstructorTest2 {
	public static void main(String[] args) {
		Kabayo2 k = new Kabayo2();
		Kabayo2 k2 = new Kabayo2("tumutugtog ng gitara");
	}
}
