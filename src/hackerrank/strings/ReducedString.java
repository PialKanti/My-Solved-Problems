package hackerrank.strings;

import java.util.Scanner;

/**
 * Problem name: Super Reduced String
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 9/20/2017
 * Time: 12:33 PM
 */
public class ReducedString {
    public static String super_reduced_string(String s) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (builder.charAt(i) == builder.charAt(i + 1)) {
                builder.delete(i, i + 2);
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputString = in.next();
        String prev = inputString;
        String res = super_reduced_string(inputString);
        while (!prev.equals(res)) {
            prev = res;
            res = super_reduced_string(res);
        }
        if (res.equals(""))
            System.out.println("Empty String");
        else
            System.out.println(res);
    }
}
