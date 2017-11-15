package HackerRank.Arrays;

import java.util.Scanner;

/**
 * Problem name: 2D Array - DS
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 11/14/2017
 * Time: 4:05 PM
 */
public class TwoDArrays {
    public static void main(String[] args) {
        int[][] a;
        int maxSum = -63;
        a = new int[6][6];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int sum = 0;
                for (int k = i; k <= i + 2; k++) {
                    if (k != i + 1) {
                        for (int l = j; l <= j + 2; l++) {
                            sum += a[k][l];
                        }
                    }
                }
                sum += a[i + 1][j + 1];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }
}
