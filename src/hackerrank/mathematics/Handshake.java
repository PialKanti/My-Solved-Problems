package hackerrank.mathematics;

import java.util.Scanner;

/**
 * Problem name: Handshake
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 12/12/2017
 * Time: 10:10 AM
 */
public class Handshake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();
            System.out.println((p * (p - 1)) / 2);
        }
    }
}
