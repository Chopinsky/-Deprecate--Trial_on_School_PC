

public class digitExt {
	
	int tNumber = 0;
	
	public digitExt(int numberSequence) {
		
		tNumber = numberSequence; 
		
	}
	
	//int i;
	
	public void returnInvertedOrder() {
		
		int arryInt[] = new int[5];
		int times = 1;
		
		for(int i = 0; i < arryInt.length; i++) {
			
			times *= 10;
			arryInt[i] = (tNumber % times) * 10 / times; 
			
		}
		
		int j = 4;
		int reverse = 0;
		int product = 1;
		
		while(j >= 0) {
			
			reverse += arryInt[j--] * product;
			product *= 10;
			//System.out.println(arryInt[j + 1]);
			System.out.print(arryInt[3 - j]);
			
		}
		System.out.println("\n" + reverse);
		
	}
	
	/*
	 * public static void main(String[] args) {
	 
		
		returnInvertedOrder();
		
	}
*/
}
