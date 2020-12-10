package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Income {
	int AadhaarNo;
	double Job;
	double Business;
	double Property;
	double TotalIncome;
	Connection connect = null;
	
	
	
	public Income(int AadhaarNo) {
		this.AadhaarNo = AadhaarNo;
	}
	
	public int  ReturnIncome(int Username)  {
		int val = 0;
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
	                .prepareStatement("select total_income from Income where aadhaar_no = ?;");
			st.setInt(1, Username);
			ResultSet rs=st.executeQuery();
			rs.next();
			val = rs.getInt(1);
		}
	catch(Exception e1){
		e1.printStackTrace();
        System.exit(0);
		
	}
		System.out.print(val);
		System.out.print("Returning val");
		return val;
		


	}
	public String Calculation(int Username) {
		String val = "";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
	                .prepareStatement("select * from Income where aadhaar_no = ?;");
			st.setInt(1, Username);
			ResultSet rs=st.executeQuery();
			rs.next();
			val = "" + "Job" + "("+rs.getString(1) + ")"+ "  " + "+" + "  " + "Buissness" + "(" + rs.getString(2) + ")" + "  " + "+" + "  "+"Property" + "(" +
			
			rs.getString(3) + ")" + "=" + "  " +rs.getString(5);
		}
	catch(Exception e1){
		e1.printStackTrace();
        System.exit(0);
		
	}
		System.out.print(val);
		System.out.print("Returning val");
		return val;
	}
	
	public void EditCredentials() {
		
	}
	
	public void Validate() {
		
	}
}


