package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise20;

public class VarargEx20 {
	public static void main(String... args) {
		for(String s : args)
			System.out.print(s + " ");
		System.out.println();
	}
}
