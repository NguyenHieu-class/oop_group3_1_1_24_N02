package com.mycompany.app.Reusing_Classes.InterfacesExercise15;

public class BasicDevice {
    private String s = "Original";
    public BasicDevice() {
        s = "Original";
    }
    protected void changeS(String c) {
        s = c;
    }
    public void showS() {
        System.out.println(s);
    }
}
