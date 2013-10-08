
public class binaryTree {

	Node root;
	static int direction = -1;  // 0: left; 1:right;
	
	public void addNode(int myID, String myName) {

		Node myNode = new Node(myID, myName);
		
		if(root == null) {
			root = myNode;
		}
		else {
			
			Node focusNode = root;
			Node parent;
			
			while(true) {
				
				parent = focusNode;
				
				if(myID < focusNode.key) {
					
					focusNode = focusNode.leftNode;
					
					if(focusNode == null) {
						parent.leftNode = myNode; 
						return;
					}
				}
				else {
					
					focusNode = focusNode.rightNode;
					
					if(focusNode == null) {
						parent.rightNode = myNode;					
						return;
					}
				}
			}
		}
		
	}
	
	public void traversalTree(Node myTree) {
		if(myTree != null) {
			
			traversalTree(myTree.leftNode);
			
			System.out.println(myTree.getString());
			
			traversalTree(myTree.rightNode);
		}
	}
	
	public void rtSum (Node myTree) {
		routeSum(myTree, 0);
	}
	
	public void routeSum(Node myTree, int sum) {
		
		sum += myTree.key;
	
		if((myTree.leftNode == null) && (myTree.rightNode == null)) {
			System.out.printf(" %d ", myTree.key);
			System.out.println(" ===> " + sum);
		}
		else {
	
			if(myTree.leftNode != null) {
				System.out.printf(" %d ---> ", myTree.key);
				routeSum(myTree.leftNode, sum);
			}
			
			if(myTree.rightNode != null) {
				System.out.printf(" %d ---> ", myTree.key);
				routeSum(myTree.rightNode, sum);
			}

		}
	}

	public int totalSum(Node myTree) {
		if(myTree == null) 
			return 0;
		else{
			return myTree.key + totalSum(myTree.leftNode) + totalSum(myTree.rightNode);
		}
	}
	
	public Node searchNode(int key) {
		
		Node focusNode = root;
		//Node parent = focusNode;
		
		while(focusNode != null) {
			if(key < focusNode.key)
			{
				System.out.printf(" %d ===> ", focusNode.key);
				//parent = focusNode;
				focusNode = focusNode.leftNode;
			}
			else if(key > focusNode.key)
			{
				System.out.printf(" %d ===> ", focusNode.key);
				//parent = focusNode;
				focusNode = focusNode.rightNode;
			}
			else if(key == focusNode.key)
			{
				System.out.println("Key: " + focusNode.key + " Found! @ " + focusNode.name);
				return focusNode;
			}
		}
		
		System.out.println("Key: " + key + " is NOT Found!");
		return null;
	}
	
	public Node nodeParent(int key) {
		
		Node focusNode = root;
		Node parent = focusNode;
		
		while(focusNode != null) {
			
			if(key == focusNode.key)
			{
				System.out.println("Key: " + focusNode.key + " Found! @ " + focusNode.name);
				return parent;
			}
			else if(key < focusNode.key)
			{
				System.out.printf(" %d ===> ", focusNode.key);
				parent = focusNode;
				focusNode = focusNode.leftNode;
				direction = 0;
			}
			else
			{
				System.out.printf(" %d ===> ", focusNode.key);
				parent = focusNode;
				focusNode = focusNode.rightNode;
				direction = 1;
			}
		}
		
		System.out.println("Key: " + key + " is NOT Found!");
		return null;
}
	
	public boolean removeNode(int key) {
		Node parent = nodeParent(key);
		//Node targetNode = searchNode(key);
		Node targetNode;
		Node tempNode;
		
		if(direction == 0) targetNode = parent.leftNode;
		else if(direction == 1) targetNode = parent.rightNode;
		else targetNode = root;
		
		if(targetNode == root){
			if(root.rightNode != null) {
				tempNode = root;
				//System.out.println(tempNode.leftNode.key);
				//System.out.println(tempNode.rightNode.key);
				
				root = tempNode.rightNode;
				root.rightNode = tempNode.rightNode.rightNode;

				appendNode(root, tempNode.leftNode);
				//System.out.println(root.leftNode.rightNode.key);
				return true;
			}
			else if(root.leftNode != null) {
				tempNode = root;
				
				root = tempNode.leftNode;
				root.leftNode = tempNode.leftNode.leftNode;
				return true;
			}
			else {
				System.out.println("Binary Tree is Empty!!!");
				return false;
			}
		}
		else{
		
		if((targetNode.leftNode == null) && (targetNode.rightNode == null)) {
			
			if(direction == 0) parent.leftNode = null;
			else parent.rightNode = null;
			
			targetNode = null;
			System.out.println("node destoyed!");
			return true;
		}
		/* Combined into left & right non-Null cases.
		else if(targetNode.leftNode == null) {

			
			if(direction == 0) parent.leftNode = targetNode.rightNode;
			else parent.rightNode = targetNode.rightNode;
				
			targetNode = null;
			System.out.println("node destoyed!");
		}*/
		else if(targetNode.rightNode == null) {	
			
			if(direction == 0) parent.leftNode = targetNode.leftNode;
			else parent.rightNode = targetNode.leftNode;
			
			targetNode = null;
			System.out.println("node destoyed!");
			return true;
		}
		else {
			tempNode = targetNode.leftNode;
			
			if(direction == 0) {
				parent.leftNode = targetNode.rightNode;
				appendNode(parent.leftNode, tempNode);  // append tempNode to targetNode
			}
			else {
				parent.rightNode = targetNode.rightNode;
				appendNode(parent.rightNode, tempNode); 
			}
			
			targetNode = null;
			System.out.println("node destoyed!");
			return true;
		}
		
		}
	}
	
	public void appendNode(Node treeNode, Node myNode) {
		Node focusNode = treeNode;
		Node parent;
		
		if(myNode == null) return;
		else {
			while(true) {
				parent = focusNode;
			
				if(myNode.key < focusNode.key) {
					if(focusNode.leftNode != null) {
						focusNode = focusNode.leftNode;
					}
					else {
						parent.leftNode = myNode;
						return;
					}
				}
				else {
					if(focusNode.rightNode != null) {
						focusNode = focusNode.rightNode;
					}
					else {
						parent.rightNode = myNode;
						return;
					}
				}
			}
		}
	}

	public void trunkTree(int key) {
		Node parent = nodeParent(key);
		Node target;
		
		if(direction == -1) {
			root = null;
			System.out.println("Binary Tree Destoyed!!\n");
		}
		else {
			if(direction == 0) parent.leftNode = null;
			else if(direction == 1) parent.rightNode = null;
		}
		
	}
	
	public static void main(String[] args) {
		
		binaryTree myTree = new binaryTree();
		
		myTree.addNode(20, "bob1");
		myTree.addNode(5, "bob2");
		myTree.addNode(78, "bob3");
		myTree.addNode(31, "bob4");
		myTree.addNode(19, "bob5");
		myTree.addNode(66, "bob6");
		myTree.addNode(49, "bob7");
		myTree.addNode(89, "bob8");
		myTree.addNode(2, "bob9");
		myTree.addNode(101, "bob8");
		
		try{
			//myTree.traversalTree(myTree.root);
			//myTree.removeNode(20);
			//myTree.traversalTree(myTree.root);
			//myTree.rtSum(myTree.root);  // equivalent to myTree.routeSum(myTree.root, 0);
			//System.out.println(myTree.totalSum(myTree.root));
			//myTree.trunkTree(101);
			myTree.rtSum(myTree.root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
