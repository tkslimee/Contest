import java.util.Scanner;

public class ALDS1_2_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] c = new String[n];
		String[] c1 = new String[n];
		String[] c2 = new String[n];
		for (int i=0; i<c1.length; i++) {
			c[i] = sc.next();
			c1[i] = new String(c[i]);
			c2[i] = new String(c[i]);
		}
		bubbleSort(c1);
		if(judge_stable(c, c1))System.out.println("Stable");
		else System.out.println("Not Stable");
		selectionSort(c2);
		if(judge_stable(c, c2))System.out.println("Stable");
		else System.out.println("Not stable");
		sc.close();
	}
	
	static void selectionSort(String[] a) {
		int count = 0;
		for ( int i=0; i<a.length; i++ ) {
			int minj = i;
			for ( int j=i; j<a.length; j++ ) {
				if ( Character.getNumericValue(a[minj].charAt(1)) > Character.getNumericValue(a[j].charAt(1)) ) {
					minj = j; 
				}
			}
			if ( minj!=i )count++;
			String v = a[minj];
			a[minj] = a[i];
			a[i] = v;
		}
		for ( int i=0; i<a.length; i++ ) {
			System.out.print(a[i]);
			if ( i!=a.length-1 )System.out.print(" ");
		}
		System.out.println("");
	}
	
	static void bubbleSort(String[] a) {
		 boolean flag = true;
		 int count = 0;
		 while ( flag ) {
			 flag = false;
			 for ( int i=0; i<a.length-1; i++ ) {
				 if ( Character.getNumericValue(a[i].charAt(1)) > Character.getNumericValue(a[i+1].charAt(1)) ) {
					 String v = a[i];
					 a[i] = a[i+1];
					 a[i+1] = v;
					 count++;
					 flag = true;
				 }
			 }
		 }
		 for ( int i=0; i<a.length; i++ ) {
			 System.out.print(a[i]);
			 if ( i!=a.length-1 )System.out.print(" ");
		 }
		 System.out.println("");
	}
	
	static boolean judge_stable(String[] in, String[] out){
		boolean ans = true;
		LOOP:
		for ( int i=0; i<in.length-1; i++ ) {
			char firstIn = in[i].charAt(0);
			int num_firstIn = Character.getNumericValue(in[i].charAt(1));
			LOOP2:
			for ( int j=i+1; j<in.length; j++ ) {
				char secondIn = in[j].charAt(0);
				int num_secondIn = Character.getNumericValue(in[j].charAt(1)); 
				if ( num_firstIn != num_secondIn )continue;
				for ( int k=0; k<in.length-1; k++ ) {
					char firstOut = out[k].charAt(0);
					int num_firstOut = Character.getNumericValue(out[k].charAt(1));
					if ( num_firstOut == num_firstIn && firstOut==firstIn ) {
						char secondOut = out[k+1].charAt(0);
						int num_secondOut = Character.getNumericValue(out[k+1].charAt(1));
						if ( firstIn!=firstOut || secondIn!=secondOut ){
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
