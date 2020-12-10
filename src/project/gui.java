package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class gui implements ActionListener{
	
	private static JLabel appTitle;
	private static JLabel userLabel;
	private static JTextField usernameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JButton registerButton;
	private static JButton okButton;
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame.setSize(800,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tax Portal");
		
		placeComponents(panel);
		frame.add(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {


        panel.setLayout(null);
        
        appTitle = new JLabel("TAX PORTAL");
        appTitle.setFont(new Font("SimSun", Font.PLAIN, 50));
        appTitle.setBounds(150, 20, 300, 75);
        panel.add(appTitle);
        
        userLabel = new JLabel("Aadhaar No:");
        userLabel.setBounds(150,100,80,25);
        panel.add(userLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(240,100,165,25);
        panel.add(usernameText);

        passwordLabel = new JLabel("Pan No:");
        passwordLabel.setBounds(150,130,80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(240,130,165,25);
        panel.add(passwordText);

        loginButton = new JButton("login");
        loginButton.setBounds(150, 180, 80, 25);
        loginButton.addActionListener(new gui());
        panel.add(loginButton);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(280, 180, 100, 25);
        registerButton.addActionListener(new registerListener());
        panel.add(registerButton);
        
        okButton = new JButton("Ok");
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Login Button Clicked");
		int username = Integer.parseInt(usernameText.getText());
		String password = passwordText.getText();
		
		
		Connection connect = null;
		try{
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
                    .prepareStatement("SELECT Aadhaar_no, Pan_no FROM Tax_Payer WHERE Aadhaar_no=? AND Pan_no=?;");
			st.setInt(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
            	System.out.println("User " + username + " logged in");
            	frame.dispose();
            	new UserPage(username);
            }
            
            else{
            	JOptionPane.showMessageDialog(okButton,"Wrong credentials, please register");
            }
			
		}catch (Exception e1) {
	         e1.printStackTrace();
	         System.exit(0);
		}
	}
	
	static class registerListener implements ActionListener {
		
		registerListener() {
			 
		}
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
    
}
