import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private ArrayList<Customer> customers;
	private int customerCount;
	private float interest;
	public Bank() {
		customers = new ArrayList<Customer>();
		customerCount = 0;
	}
	
	public void addCustomer() {
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Please Enter customer name");
		String name = scan2.nextLine();
		System.out.println("Please Enter customer's address");
		String address = scan2.nextLine();
		System.out.println("Please Enter customer's phone");
		String phone = scan2.nextLine();
	    scan2.close();
	    
	    
	    //System.out.println(name + " " + address + " " + phone);
	    Customer temp = new Customer(name, address, phone);
	   // temp.openAccount();
	   // System.out.println("HERE");
	    customers.add(temp);
	    customerCount++;
	}
	
	public void addCustomer(String name, String address, String phone) {
	        
	    //System.out.println(name + " " + address + " " + phone);
	    Customer temp = new Customer(name, address, phone);
	   // temp.openAccount();
	   // System.out.println("HERE");
	    customers.add(temp);
	    customerCount++;
	}
	
	
	public void makeTransaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter sender's name");
		String sender = scan.nextLine();
		System.out.println("Please Enter receiver's name");
		String receiver = scan.nextLine();
		int x=-1, y=-1;
		for (int i=0; i<customerCount; i++) {
			if (customers.get(i).getName() == sender) {
				x = i;	//saving sender index
			}
			if (customers.get(i).getName() == receiver) {
				y = i;	//saving receiver index
			}
		}
		
		if (x == -1 ){
			System.out.println("Invalid sender name");
			scan.close();
			return;
		}
		else if (y == -1 ){
			System.out.println("Invalid receiver name");
			scan.close();
			return;
		}
		else{
			System.out.println("Please enter amount to send");
			float amount  = scan.nextFloat();
			System.out.println("Press 1 to send from savings accout");
			System.out.println("Press 2 to send from checking accout");
			int type  = scan.nextInt();
			if(customers.get(x).withdraw(type, amount) == true) {
				customers.get(y).deposit(type, amount);
			}
			
			
		}
		scan.close();
	}
	
	public void setInterestRate(float rate) {	//for all
		this.interest = rate;
		for (int i=0; i<customers.size(); i++) {
			if (customers.get(i).hasSavings() == true) {
				customers.get(i).setInterest(rate);
			}
		}
	}
	
	public float getInterestRate() {
		return this.interest;
	}
	
	public int CustomerCount() {
		return this.customerCount;
	}
	
}
