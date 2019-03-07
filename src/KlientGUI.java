import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintStream;
import java.util.Scanner;


public class KlientGUI extends JFrame{

	final PrintStream toDysp;
	final Scanner reDysp;
	
	public KlientGUI(final PrintStream toDysp, final Scanner reDysp) {
		super("KLIENT");
		this.toDysp = toDysp;
		this.reDysp = reDysp;
		
		setBounds(100, 100, 812, 727);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 794, 680);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		panel.add(textArea);
		textArea.setBounds(130, 224, 523, 396);
		JButton btnNewButton = new JButton("ZAMAWIAM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toDysp.println("Z");
				textArea.append("OD DYSTRYBUTORA: " + reDysp.nextLine() + "\n");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(307, 29, 177, 106);
		panel.add(btnNewButton);
	
	}
}
