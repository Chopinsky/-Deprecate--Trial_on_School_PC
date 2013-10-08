
public class findMax {
	
	public static int largest(int[] A) {
		
		int currLarge = 0;
		for (int i = 1; i < A.length; i++) {
			
			if (A[currLarge] < A[i]) currLarge = i;
			
		}
		return currLarge;
					
	}
	public static void main(String[] args) {
		
		int[] myArr = {1, 4, 5, 6, 12};
		int i = largest(myArr);
		System.out.println(i + 1);
		
	}
	

}
