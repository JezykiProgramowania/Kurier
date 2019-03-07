import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.SwingUtilities;


public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		int myPort = 3333;
		String ip = "192.168.56.1";
		String kat = "A";
		String zawartosc = "zywnosc";
		
		Socket dyspS = new Socket(ip, myPort);
		final Scanner reDysp = new Scanner(dyspS.getInputStream());
		final PrintStream toDysp = new PrintStream(dyspS.getOutputStream());
		Scanner sc = new Scanner(System.in);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new KlientGUI(toDysp, reDysp);
			}
		});
		
		while(true) {
			System.out.println("Podaj sygnal: ");
			if(sc.hasNext()) {
				//toDysp.println("Zglaszam zamowienie::" + ip + ":" + kat + ":" + zawartosc);
				toDysp.println(sc.nextLine()); // Z- zglasza zamowienie
			}
			String answer = reDysp.nextLine();
			System.out.println(answer);
		}
		
		
	}

}
