package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaxableIncome {
	int AadhaarNo;
	double TotalIncome;
	double TotalInvestment;
	double Rate;
	String Slab;
	double TaxAmount;
	Connection connect = null;
	
	public TaxableIncome(int  AadhaarNo) {
		this.AadhaarNo = AadhaarNo;
	}
	
	public String Calculatetax(int Username) {
		String val = "";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
	                .prepareStatement("select * from taxable_income where aadhaar_no = ?;");
			st.setInt(1, Username);
			ResultSet rs=st.executeQuery();
			rs.next();
			val = "(" + "Total_income" + "("+rs.getString(1) + ")"+ "  " + "-" + "  " + "Total_investment" + "(" + rs.getString(2) + ")" + ")" +"  " + "*" + "  "+"Rate" + "(" +
					
					rs.getString(3) + ")" + "  "+ "/" +  "100"  + "=" + " " +rs.getString(6);
		}
	catch(Exception e1){
		e1.printStackTrace();
        System.exit(0);
		
	}
		System.out.print(val);
		System.out.print("Returning val");
		return val;
		
	}
	
	public int ReturnTaxAmt(int Username) {
		int val = 0;
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
	                .prepareStatement("select tax_amount from taxable_income where aadhaar_no = ?;");
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
	
	public double ValidateTax() {
		return TaxAmount;
	}
	
	public int TaxDue(int dueAmt,int Username) {
		
		int val = 0;
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
	                .prepareStatement("select tax_amount from taxable_income where aadhaar_no = ?;");
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
		return val - dueAmt;
		
	}	
}
