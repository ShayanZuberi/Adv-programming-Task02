import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;

public class BankTest {

	private Bank bank;
	
	@Before
	public void setup() {
		bank = new Bank();
	}
	
	@Test
	public void testCustomerCount() {
		int expectedResult = 0;
		int actualResult = bank.CustomerCount();
		//assert
		Assert.assertEquals(expectedResult, actualResult);	
	}
	
	@Test
	public void testOpenAccount() {
		bank.addCustomer("Shayan", "address", "0311-123456");
		int expectedResult = 1;
		int actualResult = bank.CustomerCount();
		//assert
		Assert.assertEquals(expectedResult, actualResult);	
	}
	
	@Test 
	public void customerCreated() {
		Customer cust = new Customer("Shayan", "address", "031158834");
		assertNotNull(cust);
	}
	
	@Test
	public void checkDeposit() {
		Account acc = new Account();
		acc.makeDeposit(2500);
		float expectedResult = 2500f;
		float actualResult = acc.checkBalance();
		Assert.assertEquals(expectedResult, actualResult, 0.1f);
	}
	
	@Test
	public void checkWithdrawalPositive() {
		Account acc = new Account();
		acc.makeDeposit(3500f);
		float actualResult = 500f;
		acc.makeWithdrawal(3000f);	//500 left
		float expectedResult = acc.checkBalance();
		Assert.assertEquals(expectedResult, actualResult, 0.1f);
	}
	
	
	@Test
	public void checkWithdrawalNegative() {
		Account acc = new Account();
		acc.makeDeposit(2500);
		boolean expectedResult = false;
		boolean actualResult = acc.makeWithdrawal(3000f);	//not enough balance
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testInterestRate() {
		bank.setInterestRate(2.5f);
		Assert.assertEquals(2.5f, bank.getInterestRate(), 0.1f);
	}
	
	@Test
	public void testCalculateTax() {
		CheckingAccount checkAcc = new CheckingAccount();
		checkAcc.makeDeposit(100f);
		checkAcc.setTaxRate(0.2f);
		float expectedResult = 20f;
		float actualResult = checkAcc.calculateTax();
		Assert.assertEquals(expectedResult, actualResult, 0.1f);
	}

	
	@Test
	public void testCalculateZakatNegative() {
		SavingsAccount savAcc = new SavingsAccount();
		savAcc.makeDeposit(10000f);
		double expectedResult = 0f;
		double actualResult = savAcc.calculateZakat();
		Assert.assertEquals(expectedResult, actualResult, 0.1);
		
	}
	
	@Test
	public void testCalculateZakat() {
		SavingsAccount savAcc = new SavingsAccount();
		savAcc.makeDeposit(20000f);
		double expectedResult = (20000*2.5)/100;
		double actualResult = savAcc.calculateZakat();
		Assert.assertEquals(expectedResult, actualResult, 0.1);
		
	}

}
