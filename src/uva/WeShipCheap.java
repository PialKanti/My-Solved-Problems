package uva;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Problem: 762 - We Ship Cheap
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 1/31/2018
 * Time: 12:48 PM
 */
public class WeShipCheap {
    static Queue queue;
    static Map<String, Integer> index;
    static int[][] edge;
    static int[] visited;
    static int[] parent;
    static String route;
    static String source, dest;
    static boolean reachable;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        while (in.hasNextLine()) {
            String str = in.nextLine();
            index = new HashMap<>();
            edge = new int[700][700];
            reachable = false;
            int num = Integer.parseInt(str);
            for (int i = 0; i < num; i++) {
                String link = in.nextLine();
                String[] vertices = link.split(" ");
                int e1 = getIndex(vertices[0]);
                int e2 = getIndex(vertices[1]);
                edge[e1][e2] = 1;
                edge[e2][e1] = 1;
            }
            String query = in.nextLine();
            String[] q = query.split(" ");
            source = q[0];
            dest = q[1];

            queue = new Queue();
            visited = new int[index.size()];
            parent = new int[index.size()];

            queue.push(getIndex(source));
            visited[getIndex(source)] = 1;
            parent[getIndex(source)] = -1;

            while (queue.size() > 0) {
                Node node = queue.pop();
                for (int i = 0; i < edge[node.data].length; i++) {
                    if (edge[node.data][i] == 1 && visited[i] == 0) {
                        queue.push(i);
                        visited[i] = 1;
                        parent[i] = node.data;
                    }
                }

                if (node.data == getIndex(dest)) {
                    reachable = true;
                    break;
                }
            }


            String empty = in.nextLine();
        }

        out.flush();
        out.close();
    }

    public static int getIndex(String s) {
        if (!index.containsKey(s)) {
            index.put(s, index.size());
        }
        return index.get(s);
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

        public Queue() {
            length = 0;
        }

        public Node push(int n) {
            Node node = new Node(n);
            length++;
            if (front == null) {
                front = node;
                end = front;
            } else {
                end.next = node;
                end = end.next;
            }

            return node;
        }

        public Node pop() {
            Node node = front;
            front = front.next;
            length--;
            return node;
        }

        public int size() {
            return length;
        }
    }
}
