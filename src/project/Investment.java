package project;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

public class Investment {
	
	int AadhaarNo;
	double HousingLoan;
	double OtherLoan;
	double Rent;
	double ProvidedFund;
	double Policies;
	double TotalInvestment;
	Connection connect = null;
	
	public Investment(int AadhaarNo) {
		this.AadhaarNo = AadhaarNo;
	}
	
	public int ReturnInvestment(int Username) {
		int val = 0;
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
	                .prepareStatement("select total_investment from investment where aadhaar_no = ?;");
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
	
	public void EditCredentials() {
		
	}
	
	public void Validate() {
		
		
	}
	
	public String Calculation(int Username) {
		
		String val = "";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
	                .prepareStatement("select * from Investment where aadhaar_no = ?;");
			st.setInt(1, Username);
			ResultSet rs=st.executeQuery();
			rs.next();
			val = "" + "Provident_fund" + "("+rs.getString(1) + ")"+ "  " + "+" + "  " + "Housing_Loan" + "(" + rs.getString(2) + ")" + "  " + "+" + "  "+"Policies" + "(" +
			
			rs.getString(3) + ")" + "  "+ "+" + "  "+ "Other_Loans" + "(" +rs.getString(4) + ")" + "  " +"+" +"  " + "Rent" + "(" +rs.getString(5) + ")" + "  " + "=" + "  " +rs.getString(7);
		}
	catch(Exception e1){
		e1.printStackTrace();
        System.exit(0);
		
	}
		System.out.print(val);
		System.out.print("Returning val");
		return val;
		
		
		
		
	}
}

