package hackerrank.mathematics;

import java.util.Scanner;

/**
 * Problem name: Maximum Draws
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 12/11/2017
 * Time: 4:59 PM
 */
public class MaximumDraws {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            System.out.println(s + 1);
        }
    }
}
