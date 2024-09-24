package com.mycompany.app.Reusing_Classes.InterfacesExercise15;
import ex15.*;

class DeviceFail {	
	public static void main(String[] s) {
		BasicDevice fail = new BasicDevice();
		fail.showS();
		// fail.changeS("good-bye"); // cannot access protected method 	
	}
}

public class Device extends BasicDevice {
	void changeBasic(String t) {
		super.changeS(t); // calls protected method
	}	
	public static void main(String[] args) {
		Device d = new Device();
		d.showS();
		d.changeBasic("Changed"); // derived class can access protected
		d.showS();
		DeviceFail.main(args);
	}
}
