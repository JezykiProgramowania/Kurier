import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class DyspozytorThread extends Dyspozytor implements Runnable{
	public static synchronized boolean isReady(List<Boolean> list) {
		boolean wynik = false;
		for(Boolean b: list) {
			if(b)return wynik = true;
		}
			return wynik;
	}
	
static volatile int mag;
int maxMag = 5;
List<Boolean> kurierList = new ArrayList<>();
int kuriers;
List<Boolean> klientList = new ArrayList<>();
PrintStream kurierOut;


public DyspozytorThread(int mag, List<Boolean> kurierList, List<Boolean> klientList,PrintStream kurierOut, int kuriers) {
	this.mag = mag;
	this.kurierList = kurierList;
	this.klientList = klientList;
	this.kurierOut = kurierOut;
	this.kuriers = kuriers;
}
	public void run() {
		while(true) {
			try {
				
				if((Dyspozytor.mag < maxMag) && isReady(kurierList)) {
					kurierOut.println("D");
					Dyspozytor.mag++;
					try {
						kurierList.remove(kurierList.size()-1);
						kuriers--;
					}catch(NoSuchElementException e) {
						System.out.println("nie ma takiego elementu");
					}
					
				}
				
				if(isReady(kurierList) && isReady(klientList)) {
					kurierOut.println("D");
					kuriers++;
					kurierList.remove(kurierList.size()-1);
					klientList.remove(klientList.size()-1);
				}
				
			} catch(NullPointerException e) {
				
			}
				
			}
	}
}
