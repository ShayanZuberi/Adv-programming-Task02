import java.time.LocalDateTime;  

public class Account {
	protected String holderName;
	protected float balance;
	protected int accountNumber;
	protected float deductions;
	LocalDateTime dateCreated;
	 
	public Account(){	//constructor 
		holderName = "undefined";
		balance = 0;
		accountNumber = -1;
		dateCreated = LocalDateTime.now();
		deductions = 0;
	}
	 
	public float checkBalance() {
		return this.balance;
	}
	
	public void makeDeposit(float amount) {
		balance += amount;
	}
	
	public boolean makeWithdrawal(float amount) {	//override in child classes
		if (this.balance >= amount) {
			balance -= amount;
			System.out.println(amount + " was withdrawn\n");
			return true;
		}
		else {
			System.out.println("Insufficient balance");
			return false;
		}
	}	

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	public void printStatement(float amount) {
		System.out.println("--------Statement---------");
		System.out.println("Customer: " + this.holderName);
		System.out.println("Account number:  " + this.accountNumber);
		System.out.println("Time: " + LocalDateTime.now());
		System.out.println("tranaction amount:  " + amount);
		System.out.println("New Balance:  " + this.balance);
		System.out.println("--------------------------");
	}
	
}
