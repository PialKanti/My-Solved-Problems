package uva;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 1/1/2018
 * Time: 9:04 PM
 */
class NodeTooFar {
    static Queue queue;
    static Map<Integer, Integer> index;
    static int[][] edge;
    static int[] visited;
    static int count;
    static int[] level;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream(new File("E:\\Java\\JavaProgram\\My-Solved-Problems\\src\\input.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        int testCase = 0;
        while (in.hasNextLine()) {
            int nc = in.nextInt();
            if (nc == 0)
                break;
            index = new HashMap<>();
            edge = new int[30][30];
            count = 0;
            for (int i = 0; i < nc; i++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                int i1 = indexOf(v1);
                int i2 = indexOf(v2);
                edge[i1][i2] = 1;
                edge[i2][i1] = 1;
            }

            while (true) {
                int node = in.nextInt();
                int ttl = in.nextInt();
                if (node == 0 && ttl == 0)
                    break;
                testCase++;

                visited = new int[30];
                level = new int[30];
                // BFS
                queue = new Queue(index.get(node));
                visited[index.get(node)] = 1;
                level[index.get(node)] = 0;

                for (Node n = queue.root; n != null; n = n.next) {
                    if (queue.length > 0) {
                        int u = queue.pop();
                        for (int i = 0; i < edge[u].length; i++) {
                            if (edge[u][i] == 1) {
                                if (visited[i] == 0) {
                                    queue.push(i);
                                    visited[i] = 1;
                                    level[i] = level[u] + 1;
                                }
                            }
                        }
                    }
                }

                int res = 0;
                for (int i = 0; i < level.length; i++) {
                    if (level[i] > 0 && level[i] <= ttl) {
                        res++;
                    }
                }
                System.out.println("Case " + testCase + ": " + ((index.size() - 1) - res) + " nodes not reachable from node " + node + " with TTL = " + ttl + ".");
            }
        }
    }

    public static int indexOf(int key) {
        if (!index.containsKey(key)) {
            index.put(key, count);
            count++;
        }
        return index.get(key);
    }

    static class Queue {
        private Node root;
        private Node current;
        private int length;

        public Queue(int n) {
            root = new Node(n);
            length = 1;
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

        public void printList() {
            Node n = root;
            while (n != null) {
                System.out.print(n.data + " ");
                n = n.next;
            }
            System.out.println();
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
