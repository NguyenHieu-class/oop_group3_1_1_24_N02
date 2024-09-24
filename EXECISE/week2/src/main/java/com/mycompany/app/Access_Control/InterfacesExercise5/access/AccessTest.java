package com.mycompany.app.Access_Control.InterfacesExercise5.access;

public class AccessTest {
    public static void main(String[] args) {
        FourWays fw = new FourWays();
        fw.showa();
        fw.showb();
        fw.showc();
        fw.a = 10;
        fw.b = 11;
        fw.c = 12;
        fw.showa();
        fw.showb();
        fw.showc();
        // fw.showd(); // Error: showd() has private access in FourWays
    }
}
