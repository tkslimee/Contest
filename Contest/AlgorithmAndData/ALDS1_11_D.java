import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class ALDS1_11_D {
	public static int[] checked;
	public static LinkedList<LinkedList<Integer>> list;
	public static int[][] dp;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        checked = new int[n];
        list = new LinkedList<LinkedList<Integer>>();
        dp = new int[n][n];
        for ( int i=0; i<n; i++ ) {
        	list.add(i, new LinkedList<Integer>());
        	Arrays.fill(dp[i], 0);
        	dp[i][i] = 1;
        }
        for ( int i=0; i<m; i++ ) {
        	int s = sc.nextInt();
        	int t = sc.nextInt();
        	list.get(s).add(t);
        	list.get(t).add(s);
        	dp[s][t] = dp[t][s] = 1;
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
        	if ( dfs(s,t)==1 ) {
        		System.out.println("yes");
        	} else {
        		System.out.println("no");
        	}
        }
    }
    
    static int dfs(int v, int goal) {
    	if ( dp[v][goal] == 1 || dp[v][goal]==2 )return dp[v][goal];
    	if ( v == goal )return dp[v][goal] = 1;
    	if ( list.get(v).isEmpty() )return dp[v][goal] = 2;
    	for ( int next: list.get(v) ) {
    		if ( checked[next] == 0 ) {
    			checked[next] = 1;
    			int tmp = dfs(next,goal);
    			dp[v][goal] = dp[v][goal]==1 ? 1 : tmp;
//    			if ( dfs(next,goal)==1 )return dp[v][goal] = 1;
    			checked[next] = 0;
    		}
    	}
    	return dp[v][goal];
    }
    static int dfs2(int v, int goal) {
    	if ( v == goal )return 1;
    	LinkedList<Integer> l = list.get(v);
    	if ( l.isEmpty() )return 2;
    	for ( int next: l ) {
    		if ( checked[next] == 0 ) {
    			checked[next] = 1;
    			if(dfs2(next,goal)==1)return 1;
    			checked[next] = 0;
    		}
    	}
    	return 2;
    }
}

//public class ALDS1_11_D {
//	public static int[] checked;
//	public static LinkedList<LinkedList<Integer>> list;
//
//    public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        checked = new int[n];
//        list = new LinkedList<LinkedList<Integer>>();
//        for ( int i=0; i<n; i++ ) {
//        	list.add(i, new LinkedList<Integer>());
//        }
//        for ( int i=0; i<m; i++ ) {
//        	int s = sc.nextInt();
//        	int t = sc.nextInt();
//        	list.get(s).add(t);
//        	list.get(t).add(s);
//        }
////        int ii=0;
////        for ( LinkedList<Integer> ll: list ) {
////        	System.out.println(ii);
////        	for ( int val: ll ) {
////        		System.out.print(" "+val);
////        	}
////        	System.out.println("");
////        	ii++;
////        }
//        int a = sc.nextInt();
//        for ( int i=0; i<a; i++ ) {
//        	Arrays.fill(checked, 0);
//        	int s = sc.nextInt();
//        	int t = sc.nextInt();
//        	checked[s] = 1;
//        	if ( dfs(s,t) ) {
//        		System.out.println("yes");
//        	} else {
//        		System.out.println("no");
//        	}
//        }
//    }
//    
//    static boolean dfs(int v, int goal) {
//    	if ( v == goal )return true;
//    	LinkedList<Integer> l = list.get(v);
//    	if ( l.isEmpty() )return false;
//    	for ( int next: l ) {
//    		if ( checked[next] == 0 ) {
//    			checked[next] = 1;
//    			if(dfs(next,goal))return true;
//    			checked[next] = 0;
//    		}
//    	}
//    	return false;
//    }
//}
