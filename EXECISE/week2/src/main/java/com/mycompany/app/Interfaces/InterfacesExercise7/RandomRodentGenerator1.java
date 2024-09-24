package com.mycompany.app.Interfaces.InterfacesExercise7;

import java.util.*;
 public class RandomRodentGenerator1 {
	private Random rand = new Random();
	public Rodent next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Mouse();
			case 1: return new Rat();
			case 2: return new Squirrel();			
		}
	}
 }
