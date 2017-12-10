package hackerrank.mathematics;

import java.util.Scanner;

/**
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 12/10/2017
 * Time: 8:45 PM
 */
public class FindThePoint {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int px = in.nextInt();
            int py = in.nextInt();
            int qx = in.nextInt();
            int qy = in.nextInt();
            System.out.println((2 * qx - px) + " " + (2 * qy - py));
        }
        in.close();
    }
}
