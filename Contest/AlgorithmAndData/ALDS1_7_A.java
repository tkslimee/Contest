import java.io.IOException;

//ª•t‚«–Ø
public class ALDS1_7_A {
	public static int nil = -1;
	public static int[] parent;
	public static int[] left;
	public static int[] right;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n];
       	left = new int[n];
       	right = new int[n];
       	for ( int i=0; i<n; i++ ) {
       		parent[i] = left[i] = right[i] = nil;
       	}
       	for ( int i=0; i<n; i++ ) {
       		int v = sc.nextInt();
       		int c_num = sc.nextInt();
       		int l = nil;
       		for ( int j=0; j<c_num; j++ ) {
       			int c = sc.nextInt();
       			if ( j == 0 ) {
       				left[v] = c;
       			} else {
       				right[l] = c;
       			}
       			l = c;
       			parent[c] = v;
       		}
       	}
       	for ( int i=0; i<n; i++ ) {
       		printAns(i);
       		System.out.println("");
       	}
    }
    
    static int getDepth(int u) {
    	int d = 0;
    	while ( parent[u] != nil ) {
    		u = parent[u];
    		d++;
    	}
    	return d;
    }
    
    static void printChild(int u) {
    	int c = left[u];
    	while ( c != nil ) {
    		System.out.print(c);
    		c = right[c];
    		if ( c != nil )System.out.print(", ");
    	}
    }
    
    static String getStatus(int u) {
    	if ( parent[u] == nil )return "root";
    	else if ( left[u] == nil )return "leaf";
    	else return "internal node";
    }
    
    static void printAns(int u) {
    	System.out.print("node "+u+": ");
    	System.out.print("parent = "+parent[u]+", ");
    	System.out.print("depth = "+getDepth(u)+", ");
    	System.out.print(getStatus(u)+", ");
    	System.out.print("[");
    	printChild(u);
    	System.out.print("]");
    }
}