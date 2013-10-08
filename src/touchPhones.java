
public class touchPhones extends cellPhones {
    // overriding the printMethod in Cellphones class
	public touchPhones() {
		super();
		//super.printMethod();
	}
	
    public void printMethod() {
       super.printMethod();
       System.out.println("I'm a touch screen cell phone");
    }
  
    public static void main (String[] args) {
      touchPhones p = new touchPhones();
      p.printMethod();
    }
}