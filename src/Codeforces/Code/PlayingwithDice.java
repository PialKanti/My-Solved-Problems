package Codeforces.Code;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PlayingwithDice {
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
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		int aw = 0,dw = 0,bw = 0;
		
		for(int i = 1;i<=6;i++){
			if(Math.abs(a-i) < Math.abs(b-i))
				aw++;
			else if(Math.abs(a-i)== Math.abs(b-i))
				dw++;
			else
				bw++;
		}
		
		out.println(aw+" "+dw+" "+bw);
		
		out.flush();
		out.close();
	}

}
