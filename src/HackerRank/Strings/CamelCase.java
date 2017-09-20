package HackerRank.Strings;

import java.util.Scanner;

/**
 * Problem name: CamelCase
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 9/20/2017
 * Time: 12:34 PM
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(wordCount(input));
    }

    public static int wordCount(String s) {
        int count = 0;
        boolean startCount = false;
        if (Character.isLowerCase(s.charAt(0))) {
            count++;
            startCount = true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (startCount && Character.isUpperCase(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}

