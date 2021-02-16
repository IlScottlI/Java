
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount a1 = new BankAccount();
		a1.deposit("Checking", 26.55);
		System.out.println(a1.getCheckingBalance());
		a1.withdraw("Checking", 60.00);
		a1.withdraw("Savings", 1.00);
		a1.deposit("Savings", 500.00);
		System.out.println(a1.getTotalMoney());
		}

}
