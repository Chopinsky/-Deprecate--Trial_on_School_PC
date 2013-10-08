
public class checkingAcc extends bankAccount{
	
	private int remainingChecks;
	
	public checkingAcc() {
		super();
		remainingChecks = 100;
	}
	
	public checkingAcc(String s, double amount, int remainingChecks) {
		super(s, amount);
		this.remainingChecks = remainingChecks;
	}
	
	public void useCheck()
	{
		remainingChecks--;
	}
	
	public void getCheck()
	{
		remainingChecks++;
	}
	
	public int checksLeft()
	{
		return remainingChecks;
	}
	
	public void deposite(double amount)
	{
		super.deposite(amount);
	}
	
	public void withdraw(double amount)
	{
		super.withdraw(amount);
	}

}
