package uva;

import java.io.*;
import java.util.Scanner;

/**
 * Problem: 567 - Risk
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 1/21/2018
 * Time: 10:34 PM
 */
public class Risk {
    static Queue queue;
    static int[][] edge;
    static int[] visited;
    static int[] level;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int testCase = 1;
        while (in.hasNextInt()) {
            edge = new int[21][21];
            for (int i = 1; i <= 19; i++) {
                int n = in.nextInt();
                for (int j = 0; j < n; j++) {
                    int node = in.nextInt();
                    edge[i][node] = 1;
                    edge[node][i] = 1;
                }
            }
            int t = in.nextInt();
            out.println("Test Set #" + testCase);
            for (int i = 0; i < t; i++) {
                boolean found = false;
                int source = in.nextInt();
                int destination = in.nextInt();

                queue = new Queue();
                visited = new int[21];
                level = new int[21];

                queue.push(source);
                visited[source] = 1;
                level[source] = 0;

                while (queue.size() > 0) {
                    int node = queue.pop();
                    for (int j = 1; j < edge[node].length; j++) {
                        if (edge[node][j] == 1 && visited[j] == 0) {
                            queue.push(j);
                            visited[j] = 1;
                            level[j] = level[node] + 1;
                            if (destination == j) {
                                found = true;
                                break;
                            }
                        }
                    }

                    if (found)
                        break;
                }

                if (source < 10) {
                    out.print(" " + source);
                } else {
                    out.print(source);
                }
                out.print(" to ");
                if (destination < 10) {
                    out.print(" " + destination);
                } else {
                    out.print(destination);
                }
                out.println(": " + level[destination]);
            }
            out.println();
            testCase++;
        }
        out.flush();
        out.close();
    }

    public static class Queue {
        private Node front;
        private Node end;
        private int length;

        public int push(int data) {
            Node node = new Node(data);
            length++;
            if (front == null) {
                front = node;
                end = front;
            } else {
                end.next = node;
                end = end.next;
            }
            return data;
        }

        public int pop() {
            length--;
            int data = front.data;
            front = front.next;
            return data;
        }

        public int size() {
            return length;
        }
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
