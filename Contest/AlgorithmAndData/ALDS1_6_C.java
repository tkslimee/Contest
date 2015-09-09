import java.io.IOException;

//quick sort
public class ALDS1_6_C {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] A = new String[n];
		String[] A_after = new String[n];
		for ( int i=0; i<n; i++ ) {
			String s = sc.next();
			String s2 = sc.next();
			A[i] = s+" "+s2;
			A_after[i] = s+" "+s2;
		}
		quickSort(A_after,0,n-1);
		boolean ans = judge_stable(A, A_after);
		if ( ans ) {
			System.out.println("Stable");
		} else {
			System.out.println("Not stable");
		}
		for ( int i=0; i<n; i++ ) {
			System.out.println(A_after[i]);
		}
	}

	static int partition(String[] A, int p, int r) {
		int x = Integer.parseInt(A[r].substring(2));
		int i = p-1;
		for ( int j=p; j<r; j++ ) {
			if ( Integer.parseInt(A[j].substring(2)) <= x ) {
				String tmp = A[++i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		String tmp2 = A[r];
		A[r] = A[i+1];
		A[i+1] = tmp2;
		return i+1;
	}
	
	static void quickSort(String[] A, int p, int r) {
		if ( p < r ) {
			int q = partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}

	static boolean judge_stable(String[] in, String[] out){
		boolean ans = true;
		LOOP:
		for ( int i=0; i<in.length-1; i++ ) {
			char firstIn = in[i].charAt(0);
			int num_firstIn = Integer.parseInt(in[i].substring(2));
			LOOP2:
			for ( int j=i+1; j<in.length; j++ ) {
				int num_secondIn = Integer.parseInt(in[j].substring(2));
				if ( num_firstIn != num_secondIn )continue;
				for ( int k=0; k<in.length-1; k++ ) {
					char firstOut = out[k].charAt(0);
					int num_firstOut = Integer.parseInt(out[k].substring(2));
					if ( num_firstOut == num_firstIn && firstOut==firstIn ) {
						if ( in[i].compareTo(out[k])!=0 || in[j].compareTo(out[k+1])!=0 ){
							ans = false;
							break LOOP;
						} else {
							break LOOP2;
						}
					}
				}
			}
		}
		return ans;
	}
}
