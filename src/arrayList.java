import java.util.*;

public class arrayList {
	
	static Scanner rd = new Scanner(System.in);
	static ArrayList<Integer> array = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		int in = rd.nextInt();
		int flag = 0;
		
		while (in != 0){
			array.add(in);
			in = rd.nextInt();
		}
		
		printArray(array);

		int del = rd.nextInt();
		for(int i = 0; i < array.size(); i++) {
			if (array.get(i) == del) {
				array.remove(i);
				flag++;
			}
		}
		if (flag == 0) {
			System.out.println("\"" +del + "\"" + " does not exist in array!");
		}
		else {
			System.out.println(flag + " element: \"" + del + "\"" + " is found and deleted!");
		}
		
		printArray(array);
	}
	
	public static void printArray(ArrayList<Integer> arr) {
		System.out.println("===========");
		for(int i : arr) {
			System.out.printf("%d  ", i);
		}
		System.out.println("\n===========");	
	}

}
