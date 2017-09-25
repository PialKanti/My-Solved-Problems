/**
 * problem/165/A 
 */
package Codeforces.Code;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SupercentralPoint {
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
		int total = 0;

		ArrayList<Point> points = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			Point p = new Point(x, y);
			points.add(p);
		}

		for (int i = 0; i < n; i++) {
			int l = 0, r = 0, t = 0, b = 0;
			Point p1 = points.get(i);
			for (int j = 0; j < n; j++) {
				if (j == i)
					continue;
				else {
					Point p2 = points.get(j);
					if (p1.x == p2.x) {
						if (p1.y > p2.y)
							b++;
						else if (p1.y < p2.y)
							t++;
					} else if (p1.y == p2.y) {
						if (p1.x > p2.x)
							l++;
						else if (p1.x < p2.x)
							r++;
					}
				}
			}

			if (l > 0 && r > 0 && t > 0 && b > 0)
				total++;
		}

		out.println(total);
		out.flush();
		out.close();

	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}

}
