package com.mycompany.app.Polymorphism.InterfaceExercise14;
import java.util.*;

public class RandomRodentGenerator {
	// same shared object to be passed to every Rodent:
	protected Shared shared = new Shared();
	private Random rand = new Random();
	public Rodent next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Mouse(shared);
			case 1: return new Rat(shared);
			case 2: return new Squirrel(shared);			
		}
	}
}
