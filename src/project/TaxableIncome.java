package project;

public class TaxableIncome {
	String AadhaarNo;
	double TotalIncome;
	double TotalInvestment;
	double Rate;
	String Slab;
	double TaxAmount;
	
	public TaxableIncome(String AadhaarNo) {
		this.AadhaarNo = AadhaarNo;
	}
	
	public double Calculatetax() {
		return TaxAmount;
	}
	
	public double ReturnTaxAmt() {
		return TaxAmount;
	}
	
	public double ValidateTax() {
		return TaxAmount;
	}
	
	public double TaxDue() {
		return TaxAmount;
	}
	
	
}
