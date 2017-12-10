/**
 * problem/255/A
 */
package codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GregsWorkout {
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

	}

	public static void main(String[] args) {
		MyScanner in = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		int n = in.nextInt();
		int chest = 0, bicep = 0, back = 0, temp;
		int c = 1;
		for (int i = 0; i < n; i++) {
			temp = in.nextInt();
			if (c % 3 == 1)
				chest += temp;
			else if (c % 3 == 2)
				bicep += temp;
			else if (c % 3 == 0)
				back += temp;
			c++;
		}

		if (chest > bicep && chest > back)
			out.println("chest");
		else if (bicep > chest && bicep > back)
			out.println("biceps");
		else if (back > chest && back > bicep)
			out.println("back");

		out.flush();
		out.close();

	}

}
