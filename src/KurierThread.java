import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class KurierThread implements Runnable{
	
	Scanner kurierIn;
	PrintStream kurierOut;
	List<Boolean> kurierList = new ArrayList<>();
	
	KurierThread(Scanner kurierIn, PrintStream kurierOut, List<Boolean> kurierList) {
		this.kurierIn = kurierIn;
		this.kurierOut = kurierOut;
		this.kurierList = kurierList;
	}
	
		public void run() {
			
			while(true) {
				String request = kurierIn.nextLine().trim();
				switch(request) {
					case "G": {
						kurierList.add(true);
						System.out.println("KurierList" + kurierList);
						kurierOut.println("OK. JESTES GOTOWY");
						break;
					}
					case "N": {
						kurierOut.println("OK. REZYGNUJESZ");
						try {
							kurierList.remove(kurierList.size()-1);
							System.out.println("KurierList" + kurierList);
						} catch(NoSuchElementException e) {
							System.out.println("No such element");
						}
						break;
					}
					default: {
						kurierOut.println("Signal unknown");
						break;
					}
				}
			}
		}
	}