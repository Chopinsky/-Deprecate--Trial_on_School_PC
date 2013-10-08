
public class myObj {
	
	int totWater = 0;
	
	public myObj() {
		//Constructor
	}
	public myObj(int waterAmount) {
		totWater = waterAmount;
	}
	
	public void addWater(int amount) {
		
		totWater += amount;
		
	}
	public void dkWater(int amount) {
		 
		totWater -= amount;
		
	}
	public int getWater() {
		
		return totWater;
		
	}

}
