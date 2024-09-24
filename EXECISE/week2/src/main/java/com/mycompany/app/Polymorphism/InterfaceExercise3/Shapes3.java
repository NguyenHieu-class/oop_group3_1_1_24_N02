package com.mycompany.app.Polymorphism.InterfaceExercise3;
import com.mycompany.app.Polymorphism.InterfaceExercise3.*;

public class Shapes3 {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[] s = new Shape[10];
		// fill up the array wth shapes:
		for(int i = 0; i < s.length; i++)
			s[i] = gen.next();
		// make polymorphic method calls:
		for(Shape shp : s) {
			shp.draw();
			shp.amend();
		}	
	}
}
