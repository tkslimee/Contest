import java.io.IOException;

public class ALDS1_8_C {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree tree = new BinarySearchTree();
        for ( int i=0; i<n; i++ ) {
        	String s = sc.next();
        	if ( s.compareTo("insert") == 0 ) {
        		int key = sc.nextInt();
        		BinarySearchTreeNode node = new BinarySearchTreeNode(key);
        		tree.insert(node);
        	} else if ( s.compareTo("find") == 0 ) {
        		int key = sc.nextInt();
        		if ( tree.find(key).getKey() != Integer.MIN_VALUE )System.out.println("yes");
        		else System.out.println("no");
        	} else if ( s.compareTo("delete") == 0 ) {
        		int key = sc.nextInt();
        		BinarySearchTreeNode dl = tree.find(key);
        		tree.deleteNode(dl);
        	} else if ( s.compareTo("print") == 0 ) {
        		tree.inOrder(tree.getRoot());
        		System.out.println("");
        		tree.preOrder(tree.getRoot());
        		System.out.println("");
        	}
        }
    }
}