package hackerrank.arrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem name: Dynamic Array 
 * 
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: Nov 16, 2017
 * Time: 5:17:17 PM
 */

public class DynamicArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		ArrayList<Integer>[] seq = new ArrayList[n];
		for(int i = 0;i <n ; i++){
			seq[i] = new ArrayList<Integer>();
		}
		int lastAns = 0;
		for(int i = 0; i < q; i++){
			int s = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int index = (x ^ lastAns) % n;
			if(s == 1){
				seq[index].add(y);
			}else if(s == 2){
				lastAns = seq[index].get(y % (seq[index].size()));
				System.out.println(lastAns);
			}
		}
	}

}
