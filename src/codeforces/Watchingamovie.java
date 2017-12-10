/**
 * problem/499/A
 */
package codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Watchingamovie {
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

		public char nextChar() {
			char c = '\0';
			try {
				c = (char) br.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return c;
		}

	}

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		int n = in.nextInt();
		int x = in.nextInt();
		int total = 0, currentMin = 1;

		for (int i = 1; i <= n; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			if (currentMin + x <= l) {
				int fact = ((l - currentMin) / x) * x;
				currentMin += fact;
			}

			total += (r - currentMin) + 1;
			currentMin = r + 1;
		}

		out.println(total);

		out.flush();
		out.close();

	}

}
