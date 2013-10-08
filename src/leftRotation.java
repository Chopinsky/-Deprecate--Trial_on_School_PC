
public class leftRotation {

	public static Node leftRotation(Node parent, Node x){
		//set x's right node as y:
		Node y = x.rightNode;
		x.rightNode = y.leftNode;
		
		//if x is the root node
		if(x == parent){
			Node root = y; // y becomes the new root
			root.leftNode = x;
			return root;  //return root;
		}
		else if(x == parent.leftNode) { //x is a left node of the parent node
			parent.leftNode = y;
			y.leftNode = x;
			return parent;
		}
		else{
			parent.rightNode = y;
			y.leftNode = x;
			return parent;
		}
	}
}
