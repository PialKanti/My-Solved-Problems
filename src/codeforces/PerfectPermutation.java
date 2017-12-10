/**
 * problem/233/A
 */
package codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PerfectPermutation {
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
		
		int n = in.nextInt();
		if(n%2 == 0){
			for(int i=2;i<=n;i+=2){
				if(i>2)
					out.print(" "+i+" "+(i-1));
				else
					out.print(i+" "+(i-1));
			}
		}else{
			out.println("-1");
		}
		
		out.flush();
		out.close();

	}

}
