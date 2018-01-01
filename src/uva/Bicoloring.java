package uva;

import java.util.Scanner;

/**
 * Problem: 10004 - Bicoloring
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 1/1/2018
 * Time: 11:43 AM
 */
public class Bicoloring {
    static Queue queue;
    static int[][] edge;
    static int[] visited;
    static int[] color; // 0 - White, 1 - Black
    static int v;
    static int e;
    static boolean biColor;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            v = in.nextInt();
            if (v == 0)
                break;
            e = in.nextInt();
            edge = new int[v][v];
            color = new int[v];
            visited = new int[v];
            biColor = true;
            for (int i = 0; i < e; i++) {
                int e1 = in.nextInt();
                int e2 = in.nextInt();
                edge[e1][e2] = 1;
                edge[e2][e1] = 1;
            }

            for (int i = 0; i < color.length; i++) {
                color[i] = -1;
            }

            queue = new Queue(0);
            visited[0] = 1;
            color[0] = 1;

            for (Node n = queue.root; n != null; n = n.next) {
                for (int i = 0; i < v; i++) {
                    if (edge[n.data][i] == 1) {
                        if (color[i] == -1) {
                            if (color[n.data] == 0)
                                color[i] = 1;
                            else if (color[n.data] == 1)
                                color[i] = 0;
                        } else {
                            if (color[i] == color[n.data]) {
                                biColor = false;
                                break;
                            }
                        }

                        if (visited[i] == 0) {
                            queue.push(i);
                        }
                    }
                }

                if (!biColor)
                    break;

                visited[n.data] = 1;
                queue.pop();
            }

            if (biColor) {
                System.out.println("BICOLORABLE.");
            } else {
                System.out.println("NOT BICOLORABLE.");
            }

        }
    }

    public static class Queue {
        private Node root;
        private Node current;
        private int length;

        public Queue(int n) {
            root = new Node(n);
            current = root;
        }

        public int push(int n) {
            Node node = new Node(n);
            current.next = node;
            current = current.next;
            length++;
            return node.data;
        }

        public int pop() {
            int n = root.data;
            root = root.next;
            length--;
            return n;
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
