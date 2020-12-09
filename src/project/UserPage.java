package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class UserPage {
	
	static JFrame frame = new JFrame();
	static JPanel ButtonPanel = new JPanel();
	
	static JPanel checkTax = new JPanel();
	static JPanel updateCredentials = new JPanel();
	static JPanel viewIncome = new JPanel();
	static JPanel viewInvestment = new JPanel();
	static JPanel taxCalculator = new JPanel();
	
	static JTabbedPane tp = new JTabbedPane();
	
	private static JTextField nameText;
	private static JTextField aadhaarNoText;
	private static JTextField panNoText;
	private static JTextField addressText;
	private static JTextField phoneText;
	
	UserPage(int username) {
		frame.setSize(800,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hello" + " " + username + " " + "Welcome to the tax portal");
		
		
		checkTaxComponents(checkTax, username);
		updateCredentialsComponents(updateCredentials, username);
		viewIncomeComponents(viewIncome, username);
		viewInvestmentComponents(viewInvestment, username);
		taxCalculatorComponents(taxCalculator, username);
		
		tp.setPreferredSize(new Dimension(50,400));
		Font font = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 18);
		tp.setFont(font);
		
		tp.setBackground(new Color(83, 83, 83));
	    tp.setForeground(new Color(255, 255, 255));
        
		tp.addTab("Check Tax", checkTax);
		tp.addTab("Update Credentials", updateCredentials);
		tp.addTab("View Income", viewIncome);
		tp.addTab("View Investment", viewInvestment);
		tp.addTab("Tax Calculator", taxCalculator);
		
		frame.add(tp);
		frame.setVisible(true);
	}
	
	private static void checkTaxComponents(JPanel panel, int username) {
		
	}
	
	private static void updateCredentialsComponents(JPanel panel, int username) {
		
		panel.setLayout(null);
		
		JLabel appTitle = new JLabel("UPDATE CREDENTIALS");
        appTitle.setFont(new Font("SimSun", Font.PLAIN, 20));
        appTitle.setBounds(150, 20, 300, 40);
        panel.add(appTitle);
		
		JLabel name = new JLabel("Name:");
		name.setBounds(10,70,80,25);
		panel.add(name);
		
		nameText = new JTextField(20);
        nameText.setBounds(100,70,165,25);
        panel.add(nameText);
		
		/*JLabel aadhaarLabel = new JLabel("Aadhaar No:");
		aadhaarLabel.setBounds(10,100,80,25);
        panel.add(aadhaarLabel);

        aadhaarNoText = new JTextField(20);
        aadhaarNoText.setBounds(100,100,165,25);
        panel.add(aadhaarNoText);
        
        JLabel panLabel = new JLabel("Pan No:");
        panLabel.setBounds(10,130,80,25);
        panel.add(panLabel);

        panNoText = new JTextField(20);
        panNoText.setBounds(100,130,165,25);
        panel.add(panNoText);
        */
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10,100,80,25);
        panel.add(addressLabel);

        addressText = new JTextField(20);
        addressText.setBounds(100,100,165,25);
        panel.add(addressText);
        
        JLabel phoneLabel = new JLabel("Phone No:");
        phoneLabel.setBounds(10,130,80,25);
        panel.add(phoneLabel);

        phoneText = new JTextField(20);
        phoneText.setBounds(100,130,165,25);
        panel.add(phoneText);
        
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(20, 180, 80, 25);
        updateButton.addActionListener(new updateCredentialsListener(username));
        panel.add(updateButton);
	}
	
	private static void viewIncomeComponents(JPanel panel, int username) {
		
	}
	
	private static void viewInvestmentComponents(JPanel panel, int username) {
		
	}
	
	private static void taxCalculatorComponents(JPanel panel, int username) {
		
	}
	
	// action listeners
	
	static class updateCredentialsListener implements ActionListener {
		
		public int username;
		
		public updateCredentialsListener(int username) {
			this.username = username;
		}
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Update Credentials button clicked");
			String name = nameText.getText();
			//int aadhaar_no = Integer.parseInt(aadhaarNoText.getText());
			//String pan_no = panNoText.getText();
			String address = addressText.getText();
			BigDecimal phone_no = new BigDecimal(phoneText.getText());
			
			TaxPayer taxPayerObj = new TaxPayer(this.username);
			
			try {
				
				taxPayerObj.ChangeCredentials(name, address, phone_no);
				
			}catch (Exception e1) {
		         e1.printStackTrace();
		         System.exit(0);
			}
			
			JButton okButton = new JButton("Ok");
			JOptionPane.showMessageDialog(okButton,"Updated successfully");
			
			frame.dispose();
			new UserPage(this.username);
			
		}
		
	}
	
	static class CheckTaxListener implements ActionListener{
		
		public int username;
		
		public CheckTaxListener(int username){
			this.username = username;
		}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Check Tax button clicked");
		}
	}
	
	static class ViewIncomeListener implements ActionListener{
		
		public int username;
		
		public ViewIncomeListener(int username){
			this.username = username;
		}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("View Income button clicked");
		}
	}
	
	static class ViewInvestmentListener implements ActionListener{
		
		public int username;
		
		public ViewInvestmentListener(int username){
			this.username = username;
		}
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("View Investment button clicked");
		}
	}
	
	static class TaxCalculatorListener implements ActionListener{
		
		public int username;
		
		public TaxCalculatorListener(int username){
			this.username = username;
		}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Tax Calulator button clicked");
		}
	}
	
}
