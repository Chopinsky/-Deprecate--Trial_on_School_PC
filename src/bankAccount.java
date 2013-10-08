
public class bankAccount {
	
	private String owner;
	private double balance;
	
	public bankAccount() {
		this.owner = "Ziwei";
		this.balance = 0.00;
	}
	
	public bankAccount(String s, double amount) {
		this.owner = s;
		this.balance = amount;
	}
	
	public void deposite(double amount) {
		//add balance
		balance += amount;
	}
	
	public void withdraw(double amount) {
		//reduce balance
		balance -= amount;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public double getBalance() {
		return this.balance;
	}

}
