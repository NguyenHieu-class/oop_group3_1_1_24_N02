package com.mycompany.app.Polymorphism.InterfaceExercise4;
import com.mycompany.app.Polymorphism.InterfaceExercise4.*;

public class Shapes4 {
    private static RandomShapeGenerator4 gen = new RandomShapeGenerator4();
    public static void main(String[] args){
        Shape[] s = new Shape[10];
        for(int i=0; i<s.length; i++){
            s[i] = gen.next();
        }
        for(Shape shp : s){
            shp.draw();
            shp.amend();
        }
    }
}
