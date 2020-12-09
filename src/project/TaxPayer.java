package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.math.BigDecimal;

public class TaxPayer {
	
	String Name;
	String PanNo;
	int AadhaarNo;
	String Address;
	BigDecimal PhoneNo;
	
	
	public TaxPayer(int username){
		this.AadhaarNo = username;
	}
	
	public void CreateNewPayer(String Name, String PanNo, int AadhaarNo, String Address, double PhoneNo) {
		
	}
	
	public void ValidatePayer(int AadhaarNo){
		
	}
	
	public void FindPayer(int AadhaarNo){
		
	}
	
	public void ChangeCredentials(String Name, String Address, BigDecimal PhoneNo) {
		
		this.Name = Name;
		this.Address = Address;
		this.PhoneNo = PhoneNo;
		
		Connection connect = null;
		try{
			Class.forName("org.postgresql.Driver");
			System.out.println("class done");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tax", "postgres", "root");
			System.out.println("connect done");
			PreparedStatement st = (PreparedStatement) connect
                    .prepareStatement("UPDATE tax_payer SET name=?, address=? WHERE aadhaar_no=?;");
			st.setString(1, this.Name);
            st.setString(2, this.Address);
            st.setInt(3,this.AadhaarNo);
            st.executeUpdate();
            
            PreparedStatement st1 = (PreparedStatement) connect
                    .prepareStatement("UPDATE phone_no SET phone_no=? WHERE aadhaar_no=?;");
            st1.setBigDecimal(1, this.PhoneNo);
            st1.setInt(2, this.AadhaarNo);
            st1.executeUpdate();
            /*if(rs.next()){
            	System.out.println("Updated successfully");
            }
            
            else{
            	System.out.println("error occured");
            }*/
            
		}catch(Exception e1) {
	         e1.printStackTrace();
	         System.exit(0);
		}
	}
}
