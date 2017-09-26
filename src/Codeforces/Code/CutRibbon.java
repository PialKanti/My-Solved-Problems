/**
 * 
 */
package Codeforces.Code;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Pial
 *
 */
public class CutRibbon {
	public static int[] state = new int[4001];
	public static int n, a, b, c;

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

		n = in.nextInt();
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();

		for (int i = 0; i < 4001; i++) {
			state[i] = -1;
		}

		int min = Math.min(a, Math.min(b, c));

		out.close();
		out.close();

	}
	
	public static void maximumPieces(int n){
		
	}

}
