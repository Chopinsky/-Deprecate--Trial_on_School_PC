//import java.util.SystemInput

public class Test1 {
	
	public static double exp(double x, double n) {
		
		if (n == 0) return 1;
		else if (n % 2 == 0) return exp(x * x, n/2);
		else return x * exp(x * x, (n - 1) / 2);
		
	}
	public static void main(String[] args) {
		
		//double x = System.in.Double;
		//double n = System.in.Double;
		double x = 1.01, n = 1000.0;
		System.out.print(exp(x, n));
		
	}

}
