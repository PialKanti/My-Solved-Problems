package hackerrank.arrays;

import java.util.Scanner;

/**
 * Problem name: arrays-DS
 * 
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: Nov 15, 2017
 * Time: 5:17:17 PM
 */

public class Arrays {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
		String s = "";
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			s = in.nextInt()+" "+s;
		}
		System.out.println(s);
    }
}
