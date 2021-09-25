
public class SavingsAccount extends Account{
	private float interestRate;
	
	public SavingsAccount(){
		this.setInterestRate(0.02f);
	}

	public double calculateInterest() {
		return (this.interestRate * this.balance);
	}	
	
	public double calculateZakat() {	//only for savings account 
		if (this.balance >= 20000) {
			return (this.balance*2.5)/100;
		}
		else return 0;
	}
	
	public void deductZakat() {
		double deduct = this.calculateZakat();
		this.deductions += deduct;
		this.balance -= deduct;
		this.displayAllDeductions();
	}
	
	public void displayAllDeductions() {
		System.out.println("The user's total Zakat deductions are: " + this.deductions);
	}
	
	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
}
