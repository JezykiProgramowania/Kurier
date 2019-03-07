import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientThread extends Dyspozytor implements Runnable {
	
	Scanner klientIn;
	PrintStream klientOut;
	volatile List<Boolean> kurierList = new ArrayList<>();
	volatile int mag;
	volatile int kuriers;
	List<Boolean> klientList = new ArrayList<>();
	
	ClientThread(Scanner klientIn, PrintStream klientOut, List<Boolean> kurierList, int mag, int kuriers, List<Boolean> klientList) {
		this.klientIn = klientIn;
		this.klientOut = klientOut;
		this.kurierList = kurierList;
		this.mag = mag;
		this.kuriers = kuriers;
		this.klientList = klientList;
	}
	public static boolean isReady(List<Boolean> list) {
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
		
	
	public void run() {
		while(true) {
			String client = klientIn.nextLine().trim();
			switch(client) {
			case "Z": {
				if(/*kuriers > 0*/ isReady(kurierList)) {
					//kurierList.remove(kurierList.size()-1);
					System.out.println("KurierList" + kurierList);
					klientList.add(true);
					klientOut.println("OK. PRZYJALEM ZAMOWIENIE");
					kuriers--;
					
					
				}
					else if(!isReady(kurierList)/*(kuriers <= 0)*/ && isMag(Dyspozytor.mag)){
						klientOut.println("BLAD!!! BRAK KURIEROW, ALE JEST MAGAZYN");
						Dyspozytor.mag--;
						System.out.println(Dyspozytor.mag);
					}
					else if(!isReady(kurierList)/*(kuriers <= 0) */&& !isMag(Dyspozytor.mag)){
						klientOut.println("BLAD!!! BRAK KURIEROW I PELNY MAGAZYN");
					}
					else {
						klientOut.println("Signal unknown");
					}
					break;
				}
			default: {
				klientOut.println("Signal unknown");
				break;
				}
			}
		}
	}
}
