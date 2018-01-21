package uva;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

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

    public static void main(String[] args) {
        int nc, root, ttl, testCase = 0;
        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (true) {
            nc = in.nextInt();
            if (nc == 0)
                break;
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

            int preNode = -1;
            while (true) {
                root = in.nextInt();
                ttl = in.nextInt();
                if (root == 0 && ttl == 0) {
                    break;
                }
                testCase++;
                if (!index.containsKey(root)) {
                    out.println("Case " + testCase + ": " + index.size() + " nodes not reachable from node " + root + " with TTL = " + ttl + ".");
                    continue;
                }


                if (root != preNode) {
                    visited = new int[30];
                    level = new int[30];
                    level = initialize(level);
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
                }

                int canVisit = 0;
                for (int i = 0; i < level.length; i++) {
                    if (level[i] <= ttl && level[i] > 0) {
                        canVisit++;
                    }
                }

                out.println("Case " + testCase + ": " + (index.size() - canVisit - 1) + " nodes not reachable from node " + root + " with TTL = " + ttl + ".");

                preNode = root;
            }
        }

        out.flush();
        out.close();
    }

    public static int indexOf(int key) {
        if (!index.containsKey(key)) {
            index.put(key, index.size());
        }
        return index.get(key);
    }

    public static int[] initialize(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        return arr;
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public char nextChar() {
            char c = '\0';
            try {
                c = (char) br.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return c;
        }

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
