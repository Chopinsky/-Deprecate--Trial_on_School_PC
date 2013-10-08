
public class trial1 implements interfaceTrial {

	@Override
	public String hitPoint() {
		// TODO Auto-generated method stub
		String characterAGotHit = "ads\n";				
		return characterAGotHit;
	}

	@Override
	public int damage(int crrHP, int damage) {
		// TODO Auto-generated method stub
		int newHealth = crrHP - damage;
		if(newHealth > 0) return newHealth;
		else return 0;
	}
	
}
