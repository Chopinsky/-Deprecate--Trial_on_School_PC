
public class intArray {
	
	public static void main(String[] args) {
		
		int arrInt[] = new int[5];
		
		//for(int i = 0; i < arrInt.length; i++) {
		//	arrInt[i] = i;
		//	System.out.println(arrInt[i]);
		//}
		int i = 0;
		while (i < arrInt.length) {
			arrInt[i] = i + 1;
			System.out.println(arrInt[i++]);
		}
		
	}

}
