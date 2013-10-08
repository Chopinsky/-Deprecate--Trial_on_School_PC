
public class Node {
	
	int key;
	String name;
	String color;
	Node leftNode;
	Node rightNode;
	
	
	Node(int incKey, String incColor) {
		
		this.key = incKey;
		this.color = incColor;
	}
	
	public String getString() {
		return "color of the node is:" + color + "; it has the key: " + key;
	}

}
