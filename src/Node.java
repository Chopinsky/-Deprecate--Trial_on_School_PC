
public class Node {
	
	int key;
	String name;
	String color;
	Node leftNode = null;
	Node rightNode = null;
	
	Node(){
		this.key = 0;
		this.color = "";
	}
	
	Node(int incKey, String incColor) {
		
		this.key = incKey;
		this.color = incColor;
	}
	
	public String getString() {
		return "color of the node is:" + color + "; its key is: " + key;
	}

}
