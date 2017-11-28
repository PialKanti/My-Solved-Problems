package HackerRank.Arrays;

import java.util.Scanner;

/**
 * Problem: Left Rotation
 * @author: Pial Kanti Samadder<pialkanti2012@gmail.com> 
 * Date: Nov 28, 2017
 * Time: 12:08:02 PM
 */
public class LeftRotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int[] result = rotation(a, d, n);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]
					+ ((i != result.length - 1) ? " " : ""));
		}
		in.close();
	}

	public static int[] rotation(int[] a, int d, int n){
		int[] res = new int[n];
		int count = 0;
		for(int i = d; i< n; i++){
			res[count] = a[i];
			count++;
		}
		for(int i = 0; i<d; i++){
			res[count] = a[i];
			count++;
		}
		return res;
	}
}
