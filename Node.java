
public class Node {
	    String type;  
	    Node left;
	    Node right;
	    String value;  

	    public Node(String type, String value) {
	        this.type = type;
	        this.value = value;
	    }

	    public Node(String type, Node left, Node right) {
	        this.type = type;
	        this.left = left;
	        this.right = right;
	    }
	}

