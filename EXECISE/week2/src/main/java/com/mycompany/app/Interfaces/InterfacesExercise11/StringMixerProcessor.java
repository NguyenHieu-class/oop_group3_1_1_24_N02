package com.mycompany.app.Interfaces.InterfacesExercise11;
import com.mycompany.app.Interfaces.InterfacesExercise11.*;

class StringMixerAdapter implements Processor {
	public String name() { return "StringMixerAdapter"; }
	StringMixer stringMixer;
	public StringMixerAdapter(StringMixer stringMixer) {
		this.stringMixer = stringMixer;
	}
	public String process(Object input) {
		return stringMixer.process((String)input);
	}	
}

public class StringMixerProcessor {
	public static void main(String[] args) {
		String s = new String(args[0]);
		Apply.process(new StringMixerAdapter(new StringMixer()), s);
	}
}
