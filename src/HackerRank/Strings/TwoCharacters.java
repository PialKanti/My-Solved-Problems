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
    private static Map<Character, Integer> frequency = new HashMap<>();
    private static int[] wordFrequency;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();
            if (input.length() > 1) {
                for (int i = 0; i < input.length(); i++) {
                    if (frequency.get(input.charAt(i)) == null) {
                        frequency.put(input.charAt(i), 1);
                    } else {
                        int value = frequency.get(input.charAt(i));
                        frequency.put(input.charAt(i), ++value);
                    }
                }
                wordFrequency = new int[frequency.size()];
                int count = 0;
                for (Map.Entry m : frequency.entrySet()) {
                    wordFrequency[count] = (int) m.getValue();
                    count++;
                }

                for (int i = 0; i < wordFrequency.length; i++) {
                    int maxIndex = i;
                    for (int j = i + 1; j < wordFrequency.length; j++) {
                        if (wordFrequency[j] > wordFrequency[maxIndex]) {
                            maxIndex = j;
                        }
                    }
                    int temp = wordFrequency[maxIndex];
                    wordFrequency[maxIndex] = wordFrequency[i];
                    wordFrequency[i] = temp;

                }

                char[] charArray = new char[wordFrequency.length];
                for (int i = 0; i < wordFrequency.length; i++) {
                    for (Map.Entry m : frequency.entrySet()) {
                        if ((int) m.getValue() == wordFrequency[i]) {
                            charArray[i] = (char) m.getKey();
                        }
                    }
                }

                int maxLen = 0;
                for (int i = 0; i < charArray.length; i++) {
                    for (int j = i + 1; j < charArray.length; j++) {
                        if (isAlternate(charArray[i], charArray[j], input)) {
                            int altLen = frequency.get(charArray[i]) + frequency.get(charArray[j]);
                            maxLen = Math.max(altLen, maxLen);
                        }
                    }
                }

                System.out.println(maxLen);
            } else {
                System.out.println(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAlternate(char c1, char c2, String s) {
        int count = 0;
        char last = '\0';
        for (int i = 0; i < s.length(); i++) {
            if (count == 0) {
                if (s.charAt(i) == c1 || s.charAt(i) == c2) {
                    count++;
                    last = s.charAt(i);
                }
            } else if (count > 0) {
                if (last == c1 && s.charAt(i) == c1) {
                    return false;
                } else if (last == c1 && s.charAt(i) == c2) {
                    count++;
                    last = s.charAt(i);
                } else if (last == c2 && s.charAt(i) == c2) {
                    return false;
                } else if (last == c2 && s.charAt(i) == c1) {
                    count++;
                    last = s.charAt(i);
                }
            }
        }
        return true;
    }
}
