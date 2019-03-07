import java.awt.Frame;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Dyspozytor {
	public static synchronized boolean isReady(List<Boolean> list) {
	boolean wynik = false;
	for(Boolean b: list) {
		if(b)return wynik = true;
	}
		return wynik;
}
	public static boolean isMag(int mag) {
		if (mag > 0) {
			return true;
		}
		return false;
	}
	public synchronized void decMag(int mag) {
		mag--;
	}
	static volatile int mag = 5;
	public static void main(String[] args) throws IOException {
		final List<Boolean> kurierList = new ArrayList<>(); 
		final List<Boolean> klientList = new ArrayList<>();
		
		int maxMag = 5;
	   int kuriers = 5;
		String ip = "133.32.2";
		int kurierPort = 5555;
		int klientPort = 3333;
		String typ = "Dostawa";
		String zawartosc = "elekronika";
		
		ServerSocket kurierSS = new ServerSocket(kurierPort);
		ServerSocket klientSS = new ServerSocket(klientPort);
		
		Socket kurierS = kurierSS.accept();
		Socket klientS = klientSS.accept();
		
		Scanner kurierIn = new Scanner(kurierS.getInputStream());
		Scanner klientIn = new Scanner(klientS.getInputStream());
		
		PrintStream kurierOut = new PrintStream(kurierS.getOutputStream());
		PrintStream klientOut = new PrintStream(klientS.getOutputStream());
		
		Thread kurierT = new Thread(new KurierThread(kurierIn, kurierOut, kurierList));
		kurierT.start();
		Thread klientT = new Thread(new ClientThread(klientIn, klientOut, kurierList, mag, kuriers, klientList));
		klientT.start();
		
		Thread dyspT = new Thread(new DyspozytorThread(mag, kurierList, klientList, kurierOut, kuriers));
		dyspT.start();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DyspozytorGUI(kurierList);
			}
		});
		
		while(true) {
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//kurierOut.println("DO KURIERA: " + ip + ":" + kurierPort + ":" + typ + ":" + zawartosc);
		//klientOut.println("DO KLIENTA: " + ip + ":" + klientPort + "Zlecenie w trakcie realizacji");
		
//		System.out.println("KURIER: " + kurierIn.nextLine());
	//	System.out.println("KLIENT: " + klientIn.nextLine());
	/*
		if(kurierIn.nextLine().equals("GOTOWY")) {
			kurierList.set(0, true);
			System.out.println("Kurier jest gotowy?: " + kurierList.get(0));
		}
		if(klientIn.nextLine().equals("Z")) {
			klientList.set(0, true);
			System.out.println("KLIENT ZLECIL ZAMOWIENIE: " + klientList.get(0));
		}
		if(isReady(kurierList) && isReady(klientList)) {
			klientOut.println("Zlecenie w trakcie realizacji");
			kurierOut.println("MASZ ZLECENIE");
		}*/
	}

}
