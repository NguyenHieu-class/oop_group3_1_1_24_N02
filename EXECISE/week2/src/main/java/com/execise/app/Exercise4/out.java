// Using protected methods in other packages is not allowed

package packageb;
import packagea.back;

public class out {

	public static void main(String[] args) {
		back obj = new back();
		// The method f() from the type ClassA is not visible
		// obj.f();
	}
}