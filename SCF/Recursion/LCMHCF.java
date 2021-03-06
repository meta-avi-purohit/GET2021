import java.util.*;

public class LCMHCF {

	public static int gcd(int x, int y) {
		if (x == 0)
			return y;
		return gcd(y % x, x);
	}

	public int recursionLCM(int x, int y) {
		return (x / gcd(x, y)) * y;
	}

	public int recursionHCF(int x, int y) {
		if (y == 0)
			return x;
		return recursionHCF(y, x % y);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Two Numbers : ");
		int x = scan.nextInt();
		int y = scan.nextInt();
		LCMHCF N = new LCMHCF();
		System.out.println("LCM of " + x + " and " + y + " : "
				+ N.recursionLCM(x, y));
		System.out.println("HCF of " + x + " and " + y + " : "
				+ N.recursionHCF(x, y));
		System.out.println("LCM of " + x + " and " + y + " : "
				+ N.recursionLCM(21, 5));
		int a = N.recursionLCM(21, 5);
		System.out.println(a);
		scan.close();
	}
}
