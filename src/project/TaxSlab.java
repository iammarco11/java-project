package project;



public class TaxSlab {
	
	String AadhaarNo;
	String Slab;
	double Rate;
	double MinAmt;
	double MaxAmt;
	
	public TaxSlab(String AadhaarNo) {
		this.AadhaarNo = AadhaarNo;		
	}
	
	public double ReturnRate() {
		return this.Rate;
	}
	
	public String ReturnSlab() {
		return this.Slab;
	}
	
	public double RateCalc() {
		return this.Rate;
	}
	
}