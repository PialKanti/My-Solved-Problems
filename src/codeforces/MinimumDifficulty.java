/**
 * problem/496/A 
 */
package codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimumDifficulty {
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
		int[] ai = new int[n];
		int[][] newAi = new int[n - 2][n - 1];
		int temp;

		for (int i = 0; i < n; i++) {
			ai[i] = in.nextInt();
		}

		int re = 1;
		for (int i = 0; i < n - 2; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (j == re) {
					continue;
				} else {
					newAi[i][cnt] = ai[j];
					cnt++;
				}
			}
			re++;
		}

		int minDiff = 2000;
		for (int i = 0; i < n - 2; i++) {
			int maxDiff = 0;
			for (int j = 0; j < n - 2; j++) {
				temp = newAi[i][j + 1] - newAi[i][j];
				maxDiff = Math.max(maxDiff, temp);
			}
			minDiff = Math.min(maxDiff, minDiff);
		}

		out.println(minDiff);

		out.flush();
		out.close();
	}

}
