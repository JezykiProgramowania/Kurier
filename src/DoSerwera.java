import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class DoSerwera implements Runnable {
	
	Scanner reDysp;
	PrintStream toDysp;
	
	public DoSerwera(Scanner reDysp, PrintStream toDysp) {
		this.reDysp = reDysp;
		this.toDysp = toDysp;
	}
	public void run() {
		
		
	}
	
}
