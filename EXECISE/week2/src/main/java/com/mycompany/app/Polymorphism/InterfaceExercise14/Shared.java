package com.mycompany.app.Polymorphism.InterfaceExercise14;
import static com.mycompany.app.Print.*;

public class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++; 
	public Shared() { println("Creating " + this); }
	public void addRef() { refcount++; }
	public String toString() { return "Shared " + id; }
	public void showRefcount() { println("refcount = " + refcount); }		
}
