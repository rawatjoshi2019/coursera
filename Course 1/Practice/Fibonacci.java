import java.util.Scanner;

public class Fibonacci {
	private static long calc_fib(long n, int m) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		long x = 1;
		long y = 2;
		long fib = y;
		for (long i = 4; i <= n; i++) {
			fib = x + y % m;
			x = y % m;
			y = fib;
		}
		return fib;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		System.out.println(calc_fib(n, 3));
		in.close();
	}
}
