package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	private static JButton checkTax;
	private static JButton updateCredentials;
	private static JButton viewIncome;
	private static JButton viewInvestment;
	private static JButton taxCalculator;
	
	UserPage(String username) {
		frame.setSize(800,400);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hello" + " " + username + " " + "Welcome to the tax portal");
				
		placeComponents(panel, username);
		frame.add(panel);
		
        frame.setVisible(true);
	}
	
	private static void placeComponents(JPanel panel, String username) {
		
		panel.setPreferredSize(new Dimension(250,250));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		
		checkTax = new JButton("Check tax");
		panel.add(checkTax);
		
		updateCredentials = new JButton("Update Credentials");
		panel.add(updateCredentials);
		
		viewIncome = new JButton("View Income");
		panel.add(viewIncome);
		
		viewInvestment = new JButton("View Investment");
		panel.add(viewInvestment);
		
		taxCalculator = new JButton("Calculate Tax");
		panel.add(taxCalculator);
    }

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
