package uva;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem: 10653 - Bombs! NO they are Mines!!
 *
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 1/24/2018
 * Time: 10:42 AM
 */
public class Bombs {
    static final int[] fx = {0, 1, 0, -1};
    static final int[] fy = {1, 0, -1, 0};
    static int[][] grid;
    static int[][] visited;
    static int[][] cost;
    static Queue queue;

    public static void main(String[] args) {
        int startX, startY, destX, destY;
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        while (in.hasNextInt()) {
            int r = in.nextInt();
            int c = in.nextInt();
            if (r == 0 && c == 0) {
                break;
            }
            grid = new int[r][c];
            int rowCount = in.nextInt();
            for (int i = 0; i < rowCount; i++) {
                int row = in.nextInt();
                int count = in.nextInt();
                for (int j = 0; j < count; j++) {
                    int col = in.nextInt();
                    grid[row][col] = 1;  // 1 means bomb
                }
            }
            startX = in.nextInt();
            startY = in.nextInt();
            destX = in.nextInt();
            destY = in.nextInt();

            queue = new Queue();
            visited = new int[r][c];
            cost = new int[r][c];

            queue.push(startX, startY);
            visited[startX][startY] = 1;
            cost[startX][startY] = 0;

            while (queue.size() > 0) {
                Node front = queue.pop();
                for (int k = 0; k < 4; k++) {
                    int nx = front.x + fx[k];
                    int ny = front.y + fy[k];
                    if ((nx >= 0 && nx < r) && (ny >= 0 && ny < c)) {
                        if (grid[nx][ny] == 0 && visited[nx][ny] == 0) {
                            queue.push(nx, ny);
                            visited[nx][ny] = 1;
                            cost[nx][ny] = cost[front.x][front.y] + 1;
                        }
                    }
                }

                if (front.x == destX && front.y == destY) {
                    break;
                }
            }

            out.println(cost[destX][destY]);
        }

        out.flush();
        out.close();
    }

    static class Queue {
        private Node front;
        private Node end;
        private int length;

        public void push(int x, int y) {
            Node node = new Node(x, y);
            length++;
            if (front == null) {
                front = node;
                end = front;
            } else {
                end.next = node;
                end = end.next;
            }
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
    }
}
