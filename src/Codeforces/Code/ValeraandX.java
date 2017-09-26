/**
 * problem/404/A
 */
package Codeforces.Code;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ValeraandX {
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
		int arrS = n - 1;
		char a, b;
		String[] arr = new String[n];
		boolean check = false;

		for (int i = 0; i <= arrS; i++) {
			arr[i] = in.nextLine();
		}

		a = arr[0].charAt(0);
		b = arr[0].charAt(1);

		if (a == b) {
			out.println("NO");
		} else {
			for (int i = 0; i <= arrS; i++) {
				String temp = arr[i];

				for (int j = 0; j <= arrS; j++) {
					if (j == i || j == (arrS - i)) {
						if (temp.charAt(j) != a) {
							check = true;
							break;
						}
					} else {
						if (temp.charAt(j) != b) {
							check = true;
							break;
						}
					}
				}
				if (check)
					break;

			}

			if (!check)
				out.println("YES");
			else
				out.println("NO");
		}

		out.flush();
		out.close();
	}

}
