package com.mycompany.app;

public class Recursion {
    int num;

    // Constructor
    Recursion() {
    } // default constructor- remember ; before }

    Recursion(int number) {
    } // constructor for int

    public int Recursion(int number) {
        this.num = number;
        if (this.num <= 1) // base case
            return 1;
        else
            return this.num * Recursion(this.num - 1);
    }

}
