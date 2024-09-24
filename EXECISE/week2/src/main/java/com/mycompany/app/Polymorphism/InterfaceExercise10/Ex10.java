package com.mycompany.app.Polymorphism.InterfaceExercise10;

class A {
	protected void f() { 
		System.out.println("A.f()");
		this.g(); 
	}
	protected void g() {
		System.out.println("A.g()"); 
	}
}

class B extends A {
	@Override protected void g() {
		System.out.println("B.g()");
	}
}

public class Ex10 {
	public static void main(String[] args) {
		B b = new B();
		// automatic upgrade to base-class to call base-class method A.f()
		// which,by polymorphism, will call the derived-class method B.g():
		b.f();
	}
}
