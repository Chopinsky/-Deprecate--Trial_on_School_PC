
public class rbInsertion {
	
	public static void rbInsert(Node root, int key){
		Node z = new Node(key, "red");
		Node focus = root;
		Node parent = root;
		
		if(root == null){
			root = z;
			root.color = "black";
			root.leftNode = null;
			root.rightNode = null;
			return;  // all done, no need to fix the Red-Black tree;
		}
		
		while(true) {
			if(z.key < focus.key){
				parent = focus;
				focus = parent.leftNode;
				
				if(focus == null) {
					focus = z;
					z.leftNode = null;
					z.rightNode = null;
					break;
				}
			}
			else{
				parent = focus;
				focus = parent.rightNode;
				
				if(focus == null) {
					focus = z;
					z.leftNode = null;
					z.rightNode = null;
					break;
				}
			}
		}
		rbInsertFix(root, z);
		return; // all fixed, Red-Black tree is good!
	}
	
	public static Node parentNode(Node root, Node z){
		Node focus = root;
		Node parent = root;

		while(z.key != focus.key && focus != null){
			if(z.key < focus.key){
				parent = focus;
				focus = parent.leftNode;
			}
			else{
				parent = focus;
				focus = parent.rightNode;
			}
		}
		
		if(focus == null) {
			System.out.println("Tree is empty, or z can't be found!");
			return null;
		}
		else return parent;
	}
	
	public static Node grandParentNode(Node root, Node z){
		Node focus = root;
		Node parent = root;
		Node grandparent = root;

		while(z.key != focus.key && focus != null){
			if(z.key < focus.key){
				grandparent = parent;
				parent = focus;
				focus = parent.leftNode;
			}
			else{
				grandparent = parent;
				parent = focus;
				focus = parent.rightNode;
			}
		}
		
		if(focus == null) {
			System.out.println("Tree is empty, or z can't be found!");
			return null;
		}
		else return grandparent;
	}

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
	
	public static Node rightRotation(Node parent, Node x){
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
	
	public static void rbInsertFix(Node root, Node z){
		Node parent = parentNode(root, z);
		Node grandparent = parentNode(root, parent);
		
		while(parent.color == "red") {
			if(parent == grandparent.leftNode){
				Node y = grandparent.rightNode;
				if(y.color == "red") {
					parent.color = "black";
					y.color = "black";
					grandparent.color = "black";
					rbInsertFix(root, z);
				}
				else if(z == parent.rightNode){
					z = parent;
					parent = parentNode(root, z);
					grandparent = parentNode(root, parent);
					z = leftRotation(z, parent);
				}
				parent.color = "black";
				grandparent.color = "red";
				
				Node greatgrandparent = parentNode(root, grandparent);
				z = rightRotation(grandparent, greatgrandparent);
			}
			else{
				Node y = grandparent.leftNode;
				if(y.color == "red") {
					parent.color = "black";
					y.color = "black";
					grandparent.color = "black";
					rbInsertFix(root, z);
				}
				else if(z == parent.leftNode){
					z = parent;
					parent = parentNode(root, z);
					grandparent = parentNode(root, parent);
					z = leftRotation(z, parent);
				}
				parent.color = "black";
				grandparent.color = "red";
				
				Node greatgrandparent = parentNode(root, grandparent);
				z = rightRotation(grandparent, greatgrandparent);
			}
		}
		root.color = "black";
		return; // all done, return
	}
	
}
