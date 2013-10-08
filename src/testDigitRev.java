import java.util.Scanner;

public class testDigitRev {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int in = input.nextInt();
		digitExt tNo = new digitExt(in); 
		tNo.returnInvertedOrder();
		
	}

}
