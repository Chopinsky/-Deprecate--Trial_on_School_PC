
public class rightRotation {
	public static Node rightRotate(Node parent, Node x){
		//set x's right node as y:
		Node y = x.leftNode;
		x.leftNode = y.rightNode;
		
		//if x is the root node
		if(x == parent){
			Node root = y; // y becomes the new root
			root.rightNode = x;
			return root;  //return root;
		}
		else if(x == parent.leftNode) { //x is a left node of the parent node
			parent.leftNode = y;
			y.rightNode = x;
			return parent;
		}
		else{
			parent.rightNode = y;
			y.rightNode = x;
			return parent;
		}
	}
}
