package HackerRank.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Problem name: Two Characters
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 9/20/2017
 * Time: 1:22 PM
 */
public class TwoCharacters {
    private static Map<Character, Integer> frequency;
    private static Map<Integer, Character> wordFrequency;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();
            frequency = new HashMap<>();
            wordFrequency = new TreeMap<>();
            for (int i = 0; i < input.length(); i++) {
                if (frequency.get(input.charAt(i)) == null) {
                    frequency.put(input.charAt(i), 1);
                } else {
                    int value = frequency.get(input.charAt(i));
                    frequency.put(input.charAt(i), ++value);
                }
            }
            for (Map.Entry m : frequency.entrySet()) {
                wordFrequency.put((Integer) m.getValue(), (Character) m.getKey());
            }
            ArrayList<Integer> keys = new ArrayList<Integer>(wordFrequency.keySet());

            int result = 0;
            for (int i = keys.size() - 1; i >= 0; i--) {
                int key = keys.get(i);
                if (wordFrequency.get(key - 1) != null) {
                    result = maxLen(wordFrequency.get(key), wordFrequency.get(key - 1), input);
                }
            }

            System.out.println("maxLen: " + result); //todo remove


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int maxLen(char a, char b, String s) {
        String word = "";
        boolean check = false;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a || s.charAt(i) == b) {
                word += s.charAt(i);
                len++;
                System.out.println(len + " " + word); //todo remove
                if ((len % 2 == 0 && word.charAt(len - 1) != b) || len % 2 != 0 && word.charAt(len - 1) != a) {
                    System.out.println(word); //todo remove
                    len = 0;
                    break;
                }
            }
        }

        return len;
    }
}
