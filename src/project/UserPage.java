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

public class UserPage {
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	
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
		checkTax.addActionListener(new CheckTax());
		panel.add(checkTax);
		
		updateCredentials = new JButton("Update Credentials");
		updateCredentials.addActionListener(new UpdateCredentials());
		panel.add(updateCredentials);
		
		viewIncome = new JButton("View Income");
		viewIncome.addActionListener(new ViewIncome());
		panel.add(viewIncome);
		
		viewInvestment = new JButton("View Investment");
		viewInvestment.addActionListener(new ViewInvestment());
		panel.add(viewInvestment);
		
		taxCalculator = new JButton("Calculate Tax");
		taxCalculator.addActionListener(new TaxCalculator());
		panel.add(taxCalculator);
    }

	static class CheckTax implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Check Tax button clicked");
		}
	}
	
	static class UpdateCredentials implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Update Credentials button clicked");
		}
	}
	
	static class ViewIncome implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("View Income button clicked");
		}
	}
	
	static class ViewInvestment implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("View Investment button clicked");
		}
	}
	
	static class TaxCalculator implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Tax Calulator button clicked");
		}
	}
}
