package com.execises.app;
import com.execises.app.Number;

public class aliasing {
    static void f(Number m){
        m.i = 15;
    }
    public static void main(String[] args) {
        Number n = new Number();
        n.i = 14;
        f(n);
        
        System.out.println(n.i);

        // Output: 15
    }
}
