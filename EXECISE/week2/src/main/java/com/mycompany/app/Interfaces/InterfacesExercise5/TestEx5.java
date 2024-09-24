package com.mycompany.app.Interfaces.InterfacesExercise5;

import interfaces.ex5.*;

public class TestEx5 implements Ex5 {
	public void sayOne() { System.out.println("one"); }
	public void sayTwo() { System.out.println("two"); }
	public void sayThree() { System.out.println("three"); }
	public static void main(String[] args) {
		TestEx5 x = new TestEx5();
		x.sayOne();
		x.sayTwo();
		x.sayThree();
	}
}
