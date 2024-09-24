package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise12;

class Tank {
	int howFull = 0;
	Tank() { this(0); }
	Tank(int fullness) {
		howFull = fullness;		
	}
	void sayHowFull() {
		if(howFull == 0) System.out.println("Tank is empty");
		else System.out.println("Tank filling status = " + howFull);
	}
	void empty() {
		howFull = 0;
	}
	protected void finalize() {
		if(howFull != 0)
			System.out.println("Error: Tank not empty");
		// Normally, you'll also do this:
		// super.finalize(); // Call the base-class version
	}
}

public class TankTest {
	public static void main(String[] args) {
		Tank tank1 = new Tank();
		Tank tank2 = new Tank(3);
		Tank tank3 = new Tank(5);
		// Proper cleanup: empty tank before going home
		tank2.empty();
		// Drop the reference, forget to cleanup:
		new Tank(6);
		System.out.println("Check tanks:");
		System.out.println("tank1: ");
		tank1.sayHowFull();
		System.out.println("tank2: ");
		tank2.sayHowFull();
		System.out.println("tank3: ");
		tank3.sayHowFull();
		System.out.println("first forced gc():");
		System.gc();
		// Force finalization on exit but using method
		// deprecated since JDK 1.1:
		System.out.println("try deprecated runFinalizersOnExit(true):");
		System.runFinalizersOnExit(true);
		System.out.println("last forced gc():");
		System.gc();
	}	
}
