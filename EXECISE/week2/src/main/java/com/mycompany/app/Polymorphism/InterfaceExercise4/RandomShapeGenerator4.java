package com.mycompany.app.Polymorphism.InterfaceExercise4;

public class RandomShapeGenerator4 {
    private Random rand = new Random();
    public Shape next() {
        switch(rand.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
            case 3: return new Rectangle();
        }
    }
}
