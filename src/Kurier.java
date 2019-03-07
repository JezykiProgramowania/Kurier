import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;
public class Kurier {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		boolean isReady = true;
		String ip = "192.168.56.1";
		int myPort = 5555;
		///DO DYSTRYBUTORA
	    Socket dyspS = new Socket(ip, myPort);
		Scanner reDysp = new Scanner(dyspS.getInputStream());
		final PrintStream toDysp = new PrintStream(dyspS.getOutputStream());
		Scanner sc = new Scanner(System.in);
		///
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new KurierGUI(toDysp);
			}
		});
		
		while(true) {
			
				try {
					String input = reDysp.nextLine();
					System.out.println(input);
					if(input.equals("D")) {		
					}

				} catch(NoSuchElementException e) {
					
				}
			
			
			/*System.out.println("Podaj sygnal: ");
			if(sc.hasNextLine()) {
				toDysp.println(sc.nextLine());		
			}	
				String answer = reDysp.nextLine();
				System.out.println(answer);*/
		}
	}
}
