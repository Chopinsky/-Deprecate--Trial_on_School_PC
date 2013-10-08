
public class binaryTreeYoutube {
	Node root;

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

	public boolean remove(int key) {
		
		Node focusNode = root;
		Node parent = root;
		
		boolean isLeft = true;
		
		while(focusNode.key != key) {
			
			parent = focusNode;
			
			if(key < focusNode.key) {
				
				isLeft = true;
				
				if(focusNode.leftNode != null) focusNode = focusNode.leftNode;
				else {
					System.out.println("NOT Found!!");
					return false;
				}
			}
			else {
				isLeft = false;
				
				if(focusNode.rightNode != null) focusNode = focusNode.rightNode;
				else {
					System.out.println("NOT Found!!");
					return false;
				}
			}
			
		}
		
		if(focusNode.leftNode == null && focusNode.rightNode == null) {
			
			if(focusNode == root) {
				root = null;
			}
			else if(isLeft) {
				parent.leftNode = null;
			}
			else {
				parent.rightNode = null;
			}
		}
		else if(focusNode.rightNode == null) {
			if(focusNode == root) root = focusNode.leftNode;
			
			else if(isLeft) parent.leftNode = focusNode.leftNode;
			
			else parent.rightNode = focusNode.leftNode;
		}
		else if(focusNode.leftNode == null) {
			if(focusNode == root) 
				root = focusNode.rightNode;
			
			else if(isLeft) 
				parent.leftNode = focusNode.rightNode;
			
			else parent.rightNode = focusNode.rightNode;
		}
		
		//using replacement method:
		else {
			
			// get the right element to replace the original removed node:
			Node replacement = getReplacementNode(focusNode);
			
			// parent node pointing to the replacement node:
			if(focusNode == root) {
				root = replacement;
			}
			else if(isLeft)
				parent.leftNode = replacement;
			else parent.rightNode = replacement;
			
			// patch the orignial left-child subtree to the replacement node:
			replacement.leftNode = focusNode.leftNode;
		}	
		
		return true;
	}

    // send the left-most leaf of the first-right child's subtree -- which is large than
	// the replacement yet smaller than any other nodes in the subtree -- to the location 
	// of the replacement, then append the entire subtree excluding the replacement node
	// as the right child of the replacement node. 
	public Node getReplacementNode(Node replacedNode) {
		// TODO Auto-generated method stub
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node focusNode = replacedNode.rightNode;
		
		while(focusNode != null) {
			replacementParent = replacement;
			
			replacement = focusNode;
			
			focusNode = focusNode.leftNode;
		}
		
		// if right child is the leaf, then just replacing. 
		if(replacement != replacedNode.rightNode) {
			replacementParent.leftNode = replacement.rightNode; // upgrade the right child of the replacement to its original location.
			replacement.rightNode = replacedNode.rightNode; // append the upgraded subtree to be the right child of the replacement
		}
		
		return replacement;
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

	public static void main(String[] args) {
		
		binaryTreeYoutube myTree = new binaryTreeYoutube();
		
		myTree.addNode(20, "bob1");
		myTree.addNode(5, "bob2");
		myTree.addNode(78, "bob3");
		myTree.addNode(31, "bob4");
		myTree.addNode(17, "bob5");
		myTree.addNode(66, "bob6");
		myTree.addNode(49, "bob7");
		myTree.addNode(89, "bob8");
		myTree.addNode(2, "bob9");
		myTree.addNode(101, "bob10");
		myTree.addNode(80, "bob11");
		
		try{
			//myTree.traversalTree(myTree.root);
			myTree.remove(78);
			myTree.rtSum(myTree.root);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
