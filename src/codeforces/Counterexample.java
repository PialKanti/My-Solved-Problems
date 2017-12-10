/**
 * problem/483/A
 */
package codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Counterexample {
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		public char nextChar(){
			char c = '\0';
			try {
				c = (char)br.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return c;
		}

	}

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		long l = in.nextLong();
		long r = in.nextLong();

		long a = 0, b = 0, c = 0;

		boolean check = false;

		if (r - l > 1) {
			for (long i = l; i <= r; i++) {
				a = i;
				for (long j = i + 1; j <= r; j++) {
					if (isCoprime(i, j)) {
						b = j;
						for (long k = j + 1; k <= r; k++) {
							if (isCoprime(j, k) && !isCoprime(i, k)) {
								c = k;
								check = true;
								break;
							}
						}
					}
					if (check)
						break;
				}
				if (check)
					break;
			}
			if (check)
				out.println(a + " " + b + " " + c);
			else
				out.println("-1");
		} else {
			out.println("-1");
		}
		out.flush();
		out.close();
	}

	public static boolean isCoprime(long a, long b) {
		int[] divisor = { 2, 3, 5, 7 };
		boolean isTrue = true;

		for (int i = 0; i < divisor.length; i++) {
			if (a % divisor[i] == 0 && b % divisor[i] == 0) {
				isTrue = false;
				break;
			}
		}

		return isTrue;
	}

}
