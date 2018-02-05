package uva;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: 429 - Word Transformation
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 2/5/2018
 * Time: 4:48 PM
 */
public class WordTransformation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String number = in.nextLine();
        int num = Integer.parseInt(number);
        String empty = in.nextLine();
        for (int i = 0; i < num; i++) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {

            }
            scanner.close();
        }

        in.close();
        out.flush();
        out.close();
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Queue {
        private Node front;
        private Node end;
        private int length;

        public Queue(int length) {
            this.length = length;
        }

        public Node push(int n) {
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
