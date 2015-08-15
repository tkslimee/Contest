import java.util.Scanner;


public class ALDS1_1_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a < b)swap(a,b);
		System.out.println(gcd(a,b));
	}
	static void swap(int a, int b) {
		int v = a;
		a = b;
		b = v;
	}
	static int gcd(int x, int y) {
		if ( y == 0 ) return x;
		return gcd(y, x%y);
	}
}
