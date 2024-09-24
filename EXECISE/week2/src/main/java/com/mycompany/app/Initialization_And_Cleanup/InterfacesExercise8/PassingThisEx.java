package com.mycompany.app.Initialization_And_Cleanup.InterfacesExercise8;

class Doc {	
	void intubate() {
		System.out.println("prepare patient");
		laryngoscopy();
		this.laryngoscopy();	
	}
	void laryngoscopy() {
		System.out.println("use laryngoscope");
	}	
}	
public class PassingThisEx{	
	public static void main(String[] args) {
		new Doc().intubate();		
	}		
}
