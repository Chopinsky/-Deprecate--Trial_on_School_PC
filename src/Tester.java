
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bankAccount boa = new bankAccount("Bob", 100);
		l(boa.getOwner());
		l(boa.getBalance());
		l("==========================");
		
		savingsAcc sa = new savingsAcc("Zuo", 1245);
		sa.depoiste(250);
		l("Initial Balance: " + sa.getBalance());
		sa.addInt(6);
		l("Final Balance after 6 months: " + sa.getBalance());
		l("==========================");
		
		checkingAcc ca = new checkingAcc("Ziwei", 250, 100);
		ca.withdraw(15.00);
		ca.useCheck();
		l("Remaining Balance of " + sa.getOwner() + " is:  " + ca.getBalance());
		l("Remaining Checks:  " + ca.checksLeft());
		l("==========================");
		
		//bankAccount caf = new checkingAccFees();
		//castCAF((checkingAccFees)caf);
		checkingAccFees caf = new checkingAccFees("ZZ", 250, 20);
		caf.withdraw(15.00);
		caf.deductFees();
		l(caf.getBalance());
		l("==========================");
		
		castTest(boa);
		castTest(sa);
		castTest(ca);
		castTest(caf);
	}
	
	public static void l(Object s)
	{
		System.out.println(s);
	}

//	public static void castCAF(checkingAccFees f) {
//		//do something with f;
//	}
	
	public static void castTest(bankAccount f) {
	    //do something with f;
		l(f.getOwner());
    }
}
