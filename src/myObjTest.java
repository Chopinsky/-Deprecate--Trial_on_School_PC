

public class myObjTest {
		
	public static void main(String[] args) {
		
		//String x = "Hallo!";
		myObj waterBottle = new myObj(0);
		waterBottle.addWater(100); // add 100L water
		waterBottle.dkWater(20);
		
		//digitExt(54321);
		
		
		System.out.println("Remaining Water Level is: " + waterBottle.getWater());
		
	}


}
