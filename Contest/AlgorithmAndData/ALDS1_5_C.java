import java.util.Scanner;


public class ALDS1_5_C {
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		double[] a = {0.0,0.0};
		double[] b = {100.0,0.0};
		System.out.println(a[0]+" "+a[1]);
		koch(1,a,b);
		System.out.println(b[0]+" "+b[1]);
	}
	static void koch(int depth, double[] p1, double[] p2) {
		if ( depth > n ) return;
		double[] s = new double[2];
		double[] t = new double[2];
		double[] u = new double[2];
		double radian = Math.toRadians(60.0);
		s[0] = (p2[0]+2*p1[0])/3;
		s[1] = (p2[1]+2*p1[1])/3;
		t[0] = (2*p2[0]+p1[0])/3;
		t[1] = (2*p2[1]+p1[1])/3;
		u[0] = (t[0]-s[0])*Math.cos(radian)-(t[1]-s[1])*Math.sin(radian)+s[0];
		u[1] = (t[0]-s[0])*Math.sin(radian)+(t[1]-s[1])*Math.cos(radian)+s[1];
		
		koch(depth+1, p1, s);
		System.out.println(s[0]+" "+s[1]);
		koch(depth+1, s, u);
		System.out.println(u[0]+" "+u[1]);
		koch(depth+1, u, t);
		System.out.println(t[0]+" "+t[1]);
		koch(depth+1, t, p2);
	}
}
