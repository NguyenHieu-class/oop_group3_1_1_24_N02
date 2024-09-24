package ch06ex08;
import static ptmoskal.Print.*;

class connection {
	private connection() { print("connection()"); }
	static connection createConnection() {
		return new connection();
	}
}

public class connectionManager {
	static int remaining = 5;
	static void showRemaining() {
		print("Available connections: " + remaining);
	}
	static connection[] connections = new connection[5];
	{
	for(connection c : connections)
		c = connection.createConnection();
	}
	public static connection getConnection() {
		if(remaining > 0) {
			print("Creating Connection");
			return connections[--remaining];
		}else
			print("No more connections available!");
			return null;
	}
	public static void main(String[] args) {
		connectionManager cm = new connectionManager();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
	}

}