

public class assemblyLine {
	public static void main(String[] args){
		int f1[] = {7, 9, 3, 4, 8, 4};
		int f2[] = {8, 5, 6, 4, 5, 7};
		int l1[] = new int[7];
		int l2[] = new int[7];
		int x1[] = {4, 2, 3, 1, 3, 4, 3};
		int x2[] = {2, 2, 1, 2, 2, 1, 2};
		
		int lineOne[] = new int[6]; 
		lineOne[0]= x2[0] + f1[0];
		int lineTwo[] = new int[6];
		lineTwo[0]= x1[0] + f1[0];
		l1[0] = 1;
		l2[0] = 2;
		
		int finalTime = 0;
		
		for(int i = 1; i < 6; ++i) {
			if(lineOne[i-1] + f1[i] < lineTwo[i-1] + x2[i] + f1[i]){
				lineOne[i] = lineOne[i-1] + f1[i];
				l1[i] = 1;
			}
			else {
				lineOne[i] = lineTwo[i-1] + x2[i] + f1[i];
				l1[i] = 2;
			}
			
			if(lineTwo[i-1] + f2[i] < lineOne[i-1] + x1[i] + f2[i]) {
				lineTwo[i] = lineTwo[i-1] + f2[i];
				l2[i] = 2;
			}
			else {
				lineTwo[i] = lineOne[i-1] + x1[i] + f2[i];
				l2[i] = 1;
			}
		}
		
		if(lineOne[5] + x1[6] < lineTwo[5] + x2[6]) {
			finalTime = lineOne[5] + x1[6];
			l1[6] = 1;
			for(int i = 0; i <= 6; ++i) {
				//System.out.printf("%d ==>", l1[i]);
				if(i == 0) System.out.println("Going into line " + l1[i]);
				else System.out.println("line " + l1[i] + ", station " + i);
			}
			System.out.printf("Coming out from line-1. Total time is: %d", finalTime);
		}
		else {
			finalTime = lineTwo[5] + x2[6];
			l2[6] = 2;
			for(int i = 0; i <= 6; ++i) {
				//System.out.printf("%d ==>", l2[i]);
				if(i == 0) System.out.println("Going into line " + l2[i]);
				else System.out.println("line " + l1[i] + ", station " + i);
			}
			System.out.printf("Coming out from line-2. Total time is: %d", finalTime);
		}
	}
}
