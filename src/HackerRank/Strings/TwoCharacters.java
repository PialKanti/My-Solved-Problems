package HackerRank.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateWord(char a, char b, int len) {
        String word = "";
        for (int i = 1; i <= len; i++) {
            if (i % 2 != 0) {
                word += a;
            } else {
                word += b;
            }
        }
        return word;
    }
}
