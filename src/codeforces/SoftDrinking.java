package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SoftDrinking {
	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next(){
			while(st == null || !st.hasMoreElements()){
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public int nextInt(){
			return Integer.parseInt(next());
		}
		
		
		public double nextDouble(){
			return Double.parseDouble(next());
		}
		
		public long nextLong()
        {
            return Long.parseLong(next());
        }
		
		public String nextLine(){
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
		MyScanner scanner = new MyScanner();
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int l = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		int p = scanner.nextInt();
		int nl = scanner.nextInt();
		int np = scanner.nextInt();
		
		int tDrink = (k*l)/nl;
		int tLime = (c*d);
		int tSalt = p/np;
		
		System.out.println(Math.min(tDrink/n,Math.min(tLime/n,tSalt/n)));
		

	}
	

}
