package uva;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 1/25/2018
 * Time: 11:20 AM
 */
public class MutantFlatworld {
    static final int N = 0, E = 1, S = 2, W = 3, L = 0, R = 1;
    static final int[][] move = {
            {3, 1},     // For N, 90L = W , 90R = E
            {0, 2},     // For E, 90L = N , 90R = S
            {1, 3},     // For S, 90L = E , 90R = W
            {2, 0}      // For W, 90L = S , 90R = N
    };

    static int[][] scent;
    static final int[] fx = {0, 1, 0, -1};
    static final int[] fy = {1, 0, -1, 0};

    public static void main(String[] args) {
        int xMax, yMax;
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        String coor = in.nextLine();
        String[] maxCor = coor.split(" ");
        xMax = Integer.parseInt(maxCor[0]);
        yMax = Integer.parseInt(maxCor[1]);
        scent = new int[xMax + 1][yMax + 1];

        while (in.hasNextLine()) {
            int x, y;
            int orien;
            boolean lost = false;
            String pos = in.nextLine();
            String[] position = pos.split(" ");
            x = Integer.parseInt(position[0]);
            y = Integer.parseInt(position[1]);
            orien = orientation(position[2]);
            String inst = in.nextLine();

            int tempX = x, tempY = y;
            for (int j = 0; j < inst.length(); j++) {
                char c = inst.charAt(j);
                if (c == 'F') {
                    tempX = x + fx[orien];
                    tempY = y + fy[orien];
                    if (tempX > xMax || tempX < 0 || tempY > yMax || tempY < 0) {
                        if (scent[x][y] == 0) {
                            scent[x][y] = 1;
                            lost = true;
                            break;
                        }
                    } else {
                        x = tempX;
                        y = tempY;
                    }
                } else {
                    orien = move[orien][movement(String.valueOf(c))];
                }
            }

            if (lost)
                System.out.println(x + " " + y + " " + orientation(orien) + " LOST");
            else
                System.out.println(x + " " + y + " " + orientation(orien));
        }

        out.flush();
        out.close();
    }

    public static int orientation(String s) {
        int or = 0;
        switch (s) {
            case "N":
                or = 0;
                break;
            case "E":
                or = 1;
                break;
            case "S":
                or = 2;
                break;
            case "W":
                or = 3;
                break;
        }
        return or;
    }

    public static String orientation(int s) {
        String or = "N";
        switch (s) {
            case 0:
                or = "N";
                break;
            case 1:
                or = "E";
                break;
            case 2:
                or = "S";
                break;
            case 3:
                or = "W";
                break;
        }
        return or;
    }

    public static int movement(String s) {
        int m = 0;
        switch (s) {
            case "L":
                m = 0;
                break;
            case "R":
                m = 1;
                break;
        }
        return m;
    }
}
