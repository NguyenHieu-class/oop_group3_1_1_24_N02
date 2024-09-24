package com.mycompany.app;
import com.mycompany.app.*;


public class App {
    public static void main(String[] args) {

        //Time.java
        Time t1 = new Time();
        Time t2 = new Time(2, 30, 45);
        System.out.println(t1);
        System.out.println(t2);

        //Book.java
        Book b1 = new Book();
        Book b2 = new Book("Java Programming", "James Gosling", 45.5);
        System.out.println(b1);
        System.out.println(b2);

        //NameNumber.java
        NameNumber nn1 = new NameNumber();
        NameNumber nn2 = new NameNumber("John", "Doe", "1234567890");
        System.out.println(nn1);
        System.out.println(nn2);

        //NNCollection.java
        NNCollection nnc = new NNCollection();
        nnc.insert(nn1);
        nnc.insert(nn2);
        System.out.println(nnc.findNumber("Doe"));

        //Recursion.java
        Recursion r = new Recursion();
        System.out.println(r.Recursion(5));

    }
}