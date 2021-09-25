import java.util.Scanner;


public class Customer {
	private String name;
	private String Address;
	private String phone;
	private boolean savings;
	private boolean checking;
	private CheckingAccount checkAcc;
	private SavingsAccount savAcc;
	
	public Customer() {
		name = "undefined";
		Address = "undefined";
		phone = "-1";
		savings = false;
		checking = false;
	}
	
	public Customer(String name, String Address, String phone) {	//parameterized constructor
		this.name = name;
		this.Address = Address;
		this.phone = phone;
		savings = false;
		checking = false;
	}
	
	public void openAccount() {
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Press 1 to open a Savings acoount");
		System.out.println("Press 2 to open a Checking acoount");
		int choice3 = Integer.parseInt(scan3.nextLine());
		if (choice3 == 1) {
			//open Savings account
			if (savings == false) {
				savings = true;
				savAcc = new SavingsAccount();
				savAcc.setHolderName(this.name);
				
			}
			else {
				System.out.println("User already has a savings account");
			}
		}
		else if (choice3 == 2) {
			//open Checking account 
			
			if (checking == false) {
				checking = true;
				checkAcc = new CheckingAccount();
				checkAcc.setHolderName(this.name);
			}
			else {
				System.out.println("User already has a checking account");
			}
		}
		scan3.close();
	}
	
	public void withdraw() {
		Scanner scan = new Scanner(System.in);
		if (this.savings == true)
			System.out.println("Press 1 to withdraw from Savings Account");
		if (this.checking == true)
			System.out.println("Press 2 to withdraw from Checking acoount");
		int choice = Integer.parseInt(scan.nextLine());
		if (choice == 1) {
			//open Savings account
			if (savings == true) {
				System.out.println("Please enter amount to withdraw");
				float amount = scan.nextFloat();
				savAcc.makeWithdrawal(amount);
			}
			else {
				System.out.println("User does not have a savings account");
			}
		}
		else if (choice == 2) {
			//open Checking account 
			if (checking == true) {
				System.out.println("Please enter amount to withdraw");
				float amount = scan.nextFloat();
				checkAcc.makeWithdrawal(amount);
			}
			else {
				System.out.println("User does not have a checking account");
			}
		}
		scan.close();
	}
	
	public boolean withdraw(int accType, float amount) {
		if (accType == 1) {
			if (savAcc.makeWithdrawal(amount) == true)
				return true;
			else 
				return false;
		}
		else if (accType == 2) {
			if (checkAcc.makeWithdrawal(amount) == true)
				return true;
			else 
				return false;
		}
		return false;
		
	}
	
	public void deposit(int acctype, float amount) {
		if (acctype == 1) {
			savAcc.makeDeposit(amount);
		}
		else if (acctype == 2) {
			checkAcc.makeDeposit(amount);
		}
	}
	
	public boolean hasSavings() {
		return this.savings;
	}
	
	public boolean hasChecking() {
		return this.checking;
	}
	
	public void setInterest(float rate) {
		savAcc.setInterestRate(rate);
	}
	
	public void getInterest() {
		savAcc.getInterestRate();
	}
	
	String getName() {
		return this.name;
	}
	
}
