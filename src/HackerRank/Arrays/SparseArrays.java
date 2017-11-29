/**
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com>
 * Date: Nov 28, 2017
 * Time: 1:18:53 PM
 */
package HackerRank.Arrays;

import java.util.Scanner;

public class SparseArrays {
	public static String[] arr;
	public static int[] freq;
	public static int len;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		arr = new String[n];
		freq = new int[n];
		len = 0;
		for (int i = 0; i < n; i++) {
			String s = in.next();
			insert(s);
		}
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			String temp = in.next();
			int j;
			for (j = 0; j < arr.length; j++) {
				if (temp.equals(arr[j])) {
					System.out.println(freq[j]);
					break;
				}
			}
			if (j >= arr.length)
				System.out.println("0");
		}
		in.close();
	}

	public static int insert(String s) {
		for (int i = 0; i < len; i++) {
			if (s.equals(arr[i])) {
				freq[i]++;
				return 0;
			}
		}
		arr[len] = s;
		freq[len] = 1;
		len++;
		return 1;
	}

}
