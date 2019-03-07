import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class DyspozytorGUI extends JFrame {

	private JTextArea textArea;
	private JButton magBtn;
	private JButton kurierBtn;
	
	List<Boolean> kurierList = new ArrayList<>();

	public DyspozytorGUI(final List<Boolean> kurierList) {
		super("Dyspozytor");
		
		this.kurierList = kurierList;
	
	setSize(600,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setLayout(new BorderLayout());
	
	magBtn = new JButton("Click me");
	textArea = new JTextArea();
	magBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			textArea.append("Lista Kurierow: \n" + kurierList + "\n");
		}
	});
	
	add(textArea, BorderLayout.CENTER);
	add(magBtn, BorderLayout.SOUTH);
}
}