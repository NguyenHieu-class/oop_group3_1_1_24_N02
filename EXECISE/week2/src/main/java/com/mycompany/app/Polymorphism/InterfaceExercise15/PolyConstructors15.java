package com.mycompany.app.Polymorphism.InterfaceExercise15;
import static com.mycompany.app.Print.*;

class Glyph {
	void draw() { print("Glyph.draw()"); }
	Glyph() {
		print("Glyph() before draw()");
		draw();
		print("Glyph() after draw()"); 
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	RoundGlyph(int r) {
		radius = r;
		print("RoundGlyph.RoundGlyph(), radius = " + radius);
	}
	void draw() {
		print("RoundGlyph.draw(), radius = " + radius);
	}
}

class RectangularGlyph extends Glyph {
	private int length = 2;
	private int width = 4;
	RectangularGlyph(int l, int w) {
		length = l;
		width = w;
		print("RectangularGlyph.RectangularGlyph(), length = " 
			+ length + ", width = " + width);
	}
	void draw() {
		print("RectangularGlyph.draw(), length = " + length 
			+ ", width = " + width);
	}
}


public class PolyConstructors15 {
	public static void main(String[] args) {
		new RoundGlyph(5);
		new RectangularGlyph(3, 6);
	}
}
