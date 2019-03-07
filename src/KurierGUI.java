import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class KurierGUI extends JFrame{

	
	
	String ip = "192.168.56.1";
	int myPort = 5555;
	
	Socket dyspS ;
	Scanner reDysp;
	final PrintStream toDysp;
	
	/**
	 * Create the application.
	 */
	public KurierGUI(final PrintStream toDysp) {
		super("Kurier");
		this.toDysp = toDysp;
		setBounds(100, 100, 830, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 812, 633);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSendReady = new JButton("READY");
		btnSendReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toDysp.println("G");
			}
		});
		
		btnSendReady.setBounds(114, 114, 186, 114);
		panel.add(btnSendReady);
		btnSendReady.setFont(new Font("Tahoma", Font.PLAIN, 21));
		
		JButton btnNotReady = new JButton("NOT READY");
		btnNotReady.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNotReady.setBounds(402, 110, 186, 114);
		btnNotReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toDysp.println("N");
			}
		});
		
		panel.add(btnNotReady);
	}
}
