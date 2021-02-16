import java.util.*; 

public class BankAccount {
	private String accountNumber;
	private Double checkingBalance;
	private Double savingsBalance ;
	public static int count = 0;
	public static Double totalMoney = 0.00;
	public BankAccount(){
		BankAccount.count++;
		this.setAccountNumber(createAccountNumber());
		this.setSavingsBalance(0.00);
		this.setCheckingBalance(0.00);
	}
	
	public Double getTotalMoney() {
		return totalMoney;
	}

	public static void setTotalMoney(Double totalMoney) {
		BankAccount.totalMoney = totalMoney;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	private void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getCheckingBalance() {
		return checkingBalance;
	}
	private void setCheckingBalance(Double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public Double getSavingsBalance() {
		return savingsBalance;
	}
	private void setSavingsBalance(Double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	public void deposit(String type, Double amount) {
		Double currentBalance;
		BankAccount.totalMoney += amount;
		switch (type) {
		case "Checking":
			currentBalance = this.getCheckingBalance();
			this.setCheckingBalance(currentBalance + amount);			
			break;
		case "Savings":
			currentBalance = this.getSavingsBalance();
			this.setSavingsBalance(currentBalance + amount);
			break;
		}
	}
	public void withdraw(String type, Double amount) {
		Double currentBalance;
		switch (type) {
		case "Checking":
			currentBalance = this.getCheckingBalance();
			if( currentBalance > amount ) {
				this.setCheckingBalance(currentBalance + amount);
				BankAccount.totalMoney -= amount;
			} else {
				System.out.println("Insufficient funds, Unable to withdraw from " + type);
			}		
			break;
		case "Savings":
			currentBalance = this.getSavingsBalance();
			if( currentBalance > amount ) {
				this.setSavingsBalance(currentBalance + amount);
				BankAccount.totalMoney -= amount;
			} else {
				System.out.println("Insufficient funds, Unable to withdraw from " + type);
			}
			break;
		}
	}
	private static String createAccountNumber() {
		String generatedString = "";
	    Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int item = r.nextInt(10) ;
           generatedString += item;
        }
	    return generatedString;
	}

}
