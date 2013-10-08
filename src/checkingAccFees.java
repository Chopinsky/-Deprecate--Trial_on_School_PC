
public class checkingAccFees extends checkingAcc
{
	
	private final double FEES = 20.00;
	
	public checkingAccFees()
	{
		super();
	}
	
	public checkingAccFees(String s, double amount, int chks) 
	{
		super(s, amount, chks);
	}
	
	public void deductFees()
	{
		this.withdraw(FEES);
	}

}
