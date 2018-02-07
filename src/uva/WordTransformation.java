package uva;

import java.io.*;
import java.util.*;

/**
 * Problem: 429 - Word Transformation
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 2/5/2018
 * Time: 4:48 PM
 */
public class WordTransformation {
    static Set<String> dict;
    static Queue queue;
    static Set<String> visited;
    static Map<String, Integer> level;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

            String number = in.readLine();
            int num = Integer.parseInt(number);
            String empty = in.readLine();
            for (int i = 0; i < num; i++) {
                dict = new HashSet<>();
                String word = in.readLine();
                while (!word.equals("*")) {
                    dict.add(word);
                    word = in.readLine();
                }
                String testCase = in.readLine();
                while (testCase != null) {
                    String[] words = testCase.split(" ");
                    queue = new Queue();
                    visited = new HashSet<>();
                    level = new HashMap<>();

                    queue.push(words[0]);
                    visited.add(words[0]);
                    level.put(words[0], 0);

                    while (queue.size() > 0) {
                        Node node = queue.pop();
                        List<String> wordList = generateWords(node.data, dict);
                        for (String s : wordList) {
                            if (!visited.contains(s)) {
                                visited.add(s);
                                level.put(s, level.get(node.data) + 1);
                            }
                        }
                        if (node.data.equals(words[1])) {
                            break;
                        }
                    }

                    out.println(testCase + " " + level.get(words[1]));
                    testCase = in.readLine();
                }
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> generateWords(String word, Set<String> dictionary) {
        List<String> words = new ArrayList<>();
        StringBuilder builder = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            for (int c = 97; c <= 122; c++) {
                StringBuilder temp = builder;
                temp.replace(i, i + 1, String.valueOf((char) c));
                if (dictionary.contains(temp.toString())) {
                    words.add(temp.toString());
                }
            }
        }
        return words;
    }

    static class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }
    }

    static class Queue {
        private Node front;
        private Node end;
        private int length;

        public Queue() {
            length = 0;
        }

        public Node push(String n) {
            Node node = new Node(n);
            length++;
            if (front == null) {
                front = node;
                end = front;
            }
            return node;
        }

        public Node pop() {
            Node node = front;
            length--;
            front = front.next;
            return node;
        }

        public int size() {
            return length;
        }
    }
}
