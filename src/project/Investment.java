package project;

public class Investment {
	
	String AadhaarNo;
	double HousingLoan;
	double OtherLoan;
	double Rent;
	double ProvidedFund;
	double Policies;
	double TotalInvestment;
	
	
	public Investment(String AadhaarNo) {
		this.AadhaarNo = AadhaarNo;
	}
	
	public double ReturnInvestment() {
		return TotalInvestment;
	}
	
	public void EditCredentials() {
		
	}
	
	public void Validate() {
		
	}
	
	public double Calculation() {
		return TotalInvestment;
	}
}
