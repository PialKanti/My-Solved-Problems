package hackerrank.mathematics;

import java.util.Scanner;

/**
 * Problem name: Minimum Height Triangle
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 12/12/2017
 * Time: 10:19 AM
 */
public class MinimumHeightTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int b = in.nextInt();
        int a = in.nextInt();
        double res = (2 * a) / (double) b;
        System.out.println((int)Math.ceil(res));
    }
}
