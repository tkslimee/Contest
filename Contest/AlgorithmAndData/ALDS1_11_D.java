import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class ALDS1_11_D {
	public static int[] checked;
	public static LinkedList<LinkedList<Integer>> list;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        checked = new int[n];
        list = new LinkedList<LinkedList<Integer>>();
        for ( int i=0; i<n; i++ ) {
        	list.add(i, new LinkedList<Integer>());
        }
        for ( int i=0; i<m; i++ ) {
        	int s = sc.nextInt();
        	int t = sc.nextInt();
        	list.get(s).add(t);
        	list.get(t).add(s);
        }
//        int ii=0;
//        for ( LinkedList<Integer> ll: list ) {
//        	System.out.println(ii);
//        	for ( int val: ll ) {
//        		System.out.print(" "+val);
//        	}
//        	System.out.println("");
//        	ii++;
//        }
        int a = sc.nextInt();
        for ( int i=0; i<a; i++ ) {
        	Arrays.fill(checked, 0);
        	int s = sc.nextInt();
        	int t = sc.nextInt();
        	checked[s] = 1;
        	if ( dfs(s,t) ) {
        		System.out.println("yes");
        	} else {
        		System.out.println("no");
        	}
        }
    }
    
    static boolean dfs(int v, int goal) {
    	if ( v == goal )return true;
    	LinkedList<Integer> l = list.get(v);
    	if ( l.isEmpty() )return false;
    	boolean ret = false;
    	for ( int next: l ) {
    		if ( checked[next] == 0 ) {
    			checked[next] = 1;
    			ret |= dfs(next,goal);
    			checked[next] = 0;
    		}
    	}
    	return ret;
    }
}
