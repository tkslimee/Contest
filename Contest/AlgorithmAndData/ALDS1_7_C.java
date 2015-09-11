import java.io.IOException;
import java.util.Arrays;

//–Ø‚Ì„‰ñ
public class ALDS1_7_C {
	public static int nil = -1;
	public static int[] parent;
	public static int[] left;
	public static int[] right;
	public static int[] D;
	public static int[] H;
	public static int[] Deg;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n];
        left = new int[n];
        right = new int[n];
        D = new int[n];
        H = new int[n];
        Deg = new int[n];
        Arrays.fill(parent, nil);
        Arrays.fill(left, nil);
        Arrays.fill(right, nil);
        for ( int i=0; i<n; i++ ) {
        	int p = sc.nextInt();
        	int l = sc.nextInt();
        	int r = sc.nextInt();
        	left[p] = l;
        	right[p] = r;
        	if ( l != nil ) {
        		parent[l] = p;
        	}
        	if ( r != nil ) {
        		parent[r] = p;
        	}
        }
        int root = findRoot();

        System.out.println("Preorder");
        preOrder(root);
        System.out.println("");

        System.out.println("Inorder");
        inOrder(root);
        System.out.println("");

        System.out.println("Postorder");
        postOrder(root);
        System.out.println("");
    }
    
    static int findRoot() {
    	int ret = 0;
    	while ( parent[ret] != nil ) {
    		ret = parent[ret];
    	}
    	return ret;
    }
    
    static void setDepth(int u, int d) {
    	D[u] = d;
    	if ( left[u] != nil )setDepth(left[u],d+1);
    	if ( right[u] != nil )setDepth(right[u],d+1);
    }
    
    static int setHeightAndDeg(int u) {
    	int ret = 0;
    	int deg = 0;
    	if ( left[u] == nil && right[u] == nil )return 0;
    	if ( left[u] != nil ) {
    		ret = Math.max(ret, setHeightAndDeg(left[u])+1);
    		deg++;
    	}
    	if ( right[u] != nil ) {
    		ret = Math.max(ret, setHeightAndDeg(right[u])+1);
    		deg++;
    	}
    	Deg[u] = deg;
    	return H[u] = ret;
    }
    
    static int getSibling(int u) {
    	if ( parent[u] == nil ) {
    		return -1;
    	} else {
    		int l = left[parent[u]];
    		int r = right[parent[u]];
    		return l==u ? r : l;
    	}
    }

    static String getStatus(int u) {
    	if ( parent[u] == nil )return "root";
    	else if ( left[u] == nil && right[u] == nil )return "leaf";
    	else return "internal node";
    }
    
    static void printAns(int u) {
    	System.out.print("node "+u+": ");
    	System.out.print("parent = "+parent[u]+", ");
    	System.out.print("sibling = "+getSibling(u)+", ");
    	System.out.print("degree = "+Deg[u]+", ");
    	System.out.print("depth = "+D[u]+", ");
    	System.out.print("height = "+H[u]+", ");
    	System.out.print(getStatus(u));
    }
    
    static void preOrder(int u) {
    	System.out.print(" "+u);
    	if ( left[u] != nil )preOrder(left[u]);
    	if ( right[u] != nil )preOrder(right[u]);
    }

    static void inOrder(int u) {
    	if ( left[u] != nil )inOrder(left[u]);
    	System.out.print(" "+u);
    	if ( right[u] != nil )inOrder(right[u]);
    }

    static void postOrder(int u) {
    	if ( left[u] != nil )postOrder(left[u]);
    	if ( right[u] != nil )postOrder(right[u]);
    	System.out.print(" "+u);
    }
    
    
}