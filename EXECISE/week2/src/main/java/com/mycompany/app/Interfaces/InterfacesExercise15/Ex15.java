package com.mycompany.app.Interfaces.InterfacesExercise15;

interface History {
	void u();
	void v();
}

interface Exam {
	void w();
	void x();
}

interface Labs {
	void y();
	void z();
}

interface Workup extends History, Exam, Labs {
	void zz();
}

abstract class Doctor {
	private int i = 0;
	abstract void doc();
}

class Anesthesiologist extends Doctor implements Workup {
	private int j = 0;
	public void u() {}
	public void v() {}
	public void w() {}
	public void x() {}
	public void y() {}
	public void z() {}
	public void zz() {}
	public void doc() {} 
}

public class Ex15 {
	public static void m1(History history) { history.v(); }
	public static void m2(Exam exam) { exam.w(); }
	public static void m3(Labs labs) { labs.y(); } 
	public static void m4(Workup workup) { workup.zz(); }
	public static void main(String[] args) {
		Anesthesiologist anes = new Anesthesiologist();
		m1(anes);
		m2(anes);
		m3(anes);
		m4(anes);
	}
}
