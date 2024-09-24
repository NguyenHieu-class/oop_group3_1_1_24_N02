package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise17;

class InitTest {
	InitTest(String s) {
		System.out.println("InitTest()");
		System.out.println(s);
	}
}

public class InitTest17 {
	public static void main(String[] args) {
		InitTest[] it = new InitTest[10];
	}
}
