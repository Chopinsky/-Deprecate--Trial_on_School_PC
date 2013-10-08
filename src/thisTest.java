

public class thisTest {
		  private int a;

		  public thisTest() {
		    this(42); // calls the other constructor
		  }

		  public thisTest(int a) {
		    this.a = a; // assigns the value of the parameter a to the field of the same name
		  }
		  
		  public void frobnicate(int a) {
			    //int a = 1;

			    System.out.println(a); // refers to the local variable a
			    System.out.println(this.a); // refers to the field a
			    System.out.println(this); // refers to this entire object
			  }
		  
		  public String toString(){
			  return "thisTest a = " + a;
		  }

	    public static void main(String[] args) {
		thisTest j = new thisTest();
		j.frobnicate(1);
	}

}
