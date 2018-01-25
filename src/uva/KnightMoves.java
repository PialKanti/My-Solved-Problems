package uva;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: 439 - Knight Moves
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 1/25/2018
 * Time: 3:47 PM
 */
public class KnightMoves {
    static final int[] fx = {1, 1, -1, -1};
    static final int[] fy = {2, -2, -2, 2};
    static Queue queue;
    static int[][] visited;
    static int[][] cost;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextLine()) {
            String input = in.nextLine();
            String[] inp = input.split(" ");
            Node source = getNode(inp[0]);
            Node dest = getNode(inp[1]);

            queue = new Queue();
            visited = new int[8][8];
            cost = new int[8][8];

            queue.push(source.x, source.y);
            visited[source.x][source.y] = 1;
            cost[source.x][source.y] = 0;

            while (queue.size() > 0) {
                Node node = queue.pop();
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + fx[i];
                    int ny = node.y + fy[i];
                    if ((nx >= 0 && nx <= 7) && (ny >= 0 && ny <= 7)) {
                        if (visited[nx][ny] == 0) {
                            queue.push(nx, ny);
                            visited[nx][ny] = 1;
                            cost[nx][ny] = cost[node.x][node.y] + 1;
                        }
                    }
                }

                if (node.x == dest.x && node.y == dest.y) {
                    break;
                }
            }

            out.println("To get from " + inp[0] + " to " + inp[1] + " takes " + cost[dest.x][dest.y] + " knight moves.");
        }

        out.flush();
        out.flush();
    }

    public static Node getNode(String num) {
        int x = (int) num.charAt(1) - 48;
        int y = (int) num.charAt(0) - 97;
        return new Node(x, y);
    }

    static class Queue {
        private Node front;
        private Node end;
        private int length;

        public Node push(int x, int y) {
            Node node = new Node(x, y);
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

    static class Node {
        int x;
        int y;
        Node next;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

}