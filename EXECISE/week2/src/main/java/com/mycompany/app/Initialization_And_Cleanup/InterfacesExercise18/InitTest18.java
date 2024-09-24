package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise18;

class InitTest {
	InitTest(String s) {
		System.out.println("InitTest()");
		System.out.println(s);
	}
}

public class InitTest18 {
	public static void main(String[] args) {
		InitTest[] it = new InitTest[5];
		for(int i = 0; i < it.length; i++)
			it[i] = new InitTest(Integer.toString(i));
	}
}
