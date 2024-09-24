package com.mycompany.app.Reusing_Classes.InterfacesExercise6;
import static net.mindview.util.Print.*;

class Game {
	Game(int i) {
		print("Game constructor");
	}	
}

class BoardGame extends Game {
	BoardGame(int i) {
		// print("BoardGame constructor"); // call to super must be first
			// statement in constructor 
		super(i); // else: "cannot find symbol: constructor Game()
		print("BoardGame constructor");
	}
}

public class Chess extends BoardGame {
	Chess() {
		super(11);
		print("Chess constructor");
	}
	public static void main(String[] args) {
		Chess x = new Chess();
	}
}
