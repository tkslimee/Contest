import java.util.Scanner;

public class ALDS1_1_D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] r = new int[n];
		for ( int i=0; i<n; i++ ) {
			r[i] = sc.nextInt();
		}
		int max = -2000000000;
		int min = r[0];
		for ( int i=1; i<n; i++ ) {
			max = Math.max(max, r[i]-min);
			min = Math.min(min, r[i]);
		}
		System.out.println(max);
	}
}
