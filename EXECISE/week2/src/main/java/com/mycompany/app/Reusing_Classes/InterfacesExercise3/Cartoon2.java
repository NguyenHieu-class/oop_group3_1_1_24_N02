package com.mycompany.app.Reusing_Classes.InterfacesExercise3;
import static org.greggordon.tools.Print.*;

class Art {
	Art() { println("Art constructor"); }
}

class Drawing extends Art {
	Drawing() { println("Drawing constructor"); }
}

public class Cartoon2 extends Drawing {
	public static void main(String[] args) {
		Cartoon2 x = new Cartoon2();
	}
}