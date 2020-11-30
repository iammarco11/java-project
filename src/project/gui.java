package project;

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
	
	private static JLabel userLabel;
	private static JTextField usernameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(800,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tax Portal");
		frame.add(panel);
		
		placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {


        panel.setLayout(null);
        userLabel = new JLabel("Username");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(100,20,165,25);
        panel.add(usernameText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new gui());
        panel.add(loginButton);
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");
		String username = usernameText.getText();
		String password = passwordText.getText();
		
		
		Connection connect = null;
		try{
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			PreparedStatement st = (PreparedStatement) connect
                    .prepareStatement("SELECT username, password FROM Tax_payer WHERE username=? AND password=?;");
			st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
            	JOptionPane.showMessageDialog(loginButton,"You have successfully logged in");
            }
            
            else{
            	JOptionPane.showMessageDialog(loginButton,"Wrong cred");
            }
			
		}catch (Exception e1) {
	         e1.printStackTrace();
	         System.exit(0);
		}
	}
    
}
