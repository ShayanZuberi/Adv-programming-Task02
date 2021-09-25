
public class CheckingAccount extends Account{
	private float transactionFees;
	private float taxrate;
	
	public CheckingAccount() {
		this.transactionFees = 0;
		this.taxrate = 0.2f;
	}
	
	public boolean makeWithdrawal(float amount) {	//override in child classes
		if (this.balance >= (amount+5000)) {
			balance -= amount;
			System.out.println(amount + " was withdrawn\n");
			return true;
		}
		else {
			System.out.println("Insufficient balance");
			return false;
		}
	}
	
	public void displayAllDeductions() {
		System.out.println("The user's total Tax deductions are: " + this.deductions);
	}
	

	public float getTransactionFees() {
		return transactionFees;
	}

	public void setTransactionFees(float transactionFees) {
		this.transactionFees = transactionFees;
	}

	public float calculateTax() {
		return (this.taxrate * this.balance);
	}
	
	public void setTaxRate(float tax) {
		this.taxrate = tax;
	}
	
	public float getTaxRate() {
		return this.taxrate;
	}
	
	public void deductTax() {
		double deduct = this.calculateTax();
		this.deductions += deduct;
		this.balance -= deduct;
		this.displayAllDeductions();
	}
}
