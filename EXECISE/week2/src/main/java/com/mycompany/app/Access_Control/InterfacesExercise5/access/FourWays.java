package com.mycompany.app.Access_Control.InterfacesExercise5.access;

public class FourWays {
    int a = 0;
    private int b = 1;
    protected int c = 2;
    private int d = 3;
    FourWays(){System.out.println("FourWays() constructor");}
    void showa(){System.out.println(a);}
    public void showb(){System.out.println(b);}
    protected void showc(){System.out.println(c);}
    private void showd(){System.out.println(d);}
}
