import java.util.Scanner;


public class ALDS1_1_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i=0; i<n; i++ ) {
			int l = sc.nextInt();
			if ( primeNumCheck(l) ){
//				System.out.println(l);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static boolean primeNumCheck(int l) {
		if ( l!=2 && (l%2==0 || l==1) ){
			return false;
		} else {
			int sqrt_l = (int)Math.sqrt((double)l);
			if ( sqrt_l < 3 )return true;
			for ( int i=3; i<=sqrt_l; i+=2) {
				if ( l%i == 0 )return false;
			}
		}
		return true;
	}

}
