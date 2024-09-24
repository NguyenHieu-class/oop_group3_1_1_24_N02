package com.mycompany.app.Interfaces.InterfacesExercise19;

import java.util.*;
import static org.greggordon.tools.Print.*;

interface Games {
	void play();
}

interface GamesFactory {
	Games getGames();
}

class CoinToss implements Games {
	Random rand = new Random();
	public void play() { 
		print("Toss Coin: ");
		switch(rand.nextInt(2)) {
			case 0 : println("Heads"); return;
			case 1 : println("Tails"); return;
			default: println("OnEdge"); return;
		} 
	}
}

class CoinTossFactory implements GamesFactory {
	public Games getGames() {
		return new CoinToss();
	}
}

class DiceThrow implements Games {
	Random rand = new Random();
	public void play() { 
		print("Throw Dice: " + (rand.nextInt(6) + 1));		
	}
}

class DiceThrowFactory implements GamesFactory {
	public Games getGames() {
		return new DiceThrow();
	}
}


public class Games19 {
	public static void playGame(GamesFactory factory) {
		Games g = factory.getGames();
		g.play();
	}
	public static void main(String [] args) {
		playGame(new CoinTossFactory());
		playGame(new DiceThrowFactory());			
	}
}
