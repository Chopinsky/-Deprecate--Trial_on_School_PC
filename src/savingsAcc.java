public class savingsAcc extends bankAccount {

	private final double interestRate = 0.05;

	public savingsAcc() {
		super();
	}

	public savingsAcc(String s, double initialAmount) {
		super(s, initialAmount);
	}
    
	//Composite Interest
	public void addInt(int months) {
		//double increase;
		for(int i = 0; i < months; i++)
			this.deposite((this.getBalance() * interestRate));
		//this.deposit(increase);
	}
	
	public void depoiste(double amount) {
		super.deposite(amount);
	}
	
	public void withdraw(double amount) {
		super.withdraw(amount);
	}

}
