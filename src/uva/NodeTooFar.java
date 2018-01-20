package uva;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    static int[] level;
    static PrintWriter pw;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream(new File("input/input.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pw = new PrintWriter("output/output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int nc, root, ttl, testCase = 0;
        Scanner in = new Scanner(System.in);
        nc = in.nextInt();
        while (nc != 0) {
            index = new HashMap<>();
            edge = new int[30][30];
            for (int i = 0; i < nc; i++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                int i1 = indexOf(v1);
                int i2 = indexOf(v2);
                edge[i1][i2] = 1;
                edge[i2][i1] = 1;
            }


            while (true) {
                root = in.nextInt();
                ttl = in.nextInt();
                if (root == 0 && ttl == 0) {
                    break;
                }
                testCase++;
                if (!index.containsKey(root)) {
//                    System.out.println("Case " + testCase + ": " + index.size() + " nodes not reachable from node " + root + " with TTL = " + ttl + ".");
                    pw.println("Case " + testCase + ": " + index.size() + " nodes not reachable from node " + root + " with TTL = " + ttl + ".");
                    continue;
                }

                visited = new int[30];
                level = new int[30];
                // BFS
                queue = new Queue();
                queue.push(index.get(root));
                visited[index.get(root)] = 1;
                level[index.get(root)] = 0;

                while (queue.size() > 0) {
                    int node = queue.pop();
                    for (int i = 0; i < edge[node].length; i++) {
                        if (edge[node][i] == 1 && visited[i] == 0) {
                            queue.push(i);
                            visited[i] = 1;
                            level[i] = level[node] + 1;
                        }
                    }
                }

                for (Map.Entry<Integer, Integer> m : index.entrySet()) {
                    System.out.println(m.getKey() + " : " + m.getValue());
                }
                for (int i = 0; i < level.length; i++) {
                    System.out.println(level[i]);
                }

                int res = 0;
                for (int i = 0; i < level.length; i++) {
                    if (level[i] > ttl) {
                        res++;
                    }
                }

                System.out.println(res);
//                System.out.println("Case " + testCase + ": " + res + " nodes not reachable from node " + root + " with TTL = " + ttl + ".");
                pw.println("Case " + testCase + ": " + res + " nodes not reachable from node " + root + " with TTL = " + ttl + ".");
            }
            nc = in.nextInt();
        }

        pw.close();
    }

    public static int indexOf(int key) {
        if (!index.containsKey(key)) {
            index.put(key, index.size());
        }
        return index.get(key);
    }

    static class Queue {
        private Node front;
        private Node end;
        private int length;

        public int push(int n) {
            Node node = new Node(n);
            length++;
            if (front == null) {
                front = node;
                end = front;
            } else {
                end.next = node;
                end = end.next;
            }
            return n;
        }

        public int pop() {
            int n = front.data;
            front = front.next;
            length--;
            return n;
        }

        public int size() {
            return length;
        }

        public void printList() {
            Node n = front;
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
