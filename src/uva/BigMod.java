package uva;

import java.io.*;

/**
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 4/29/2018
 * Time: 6:07 PM
 */
public class BigMod {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        try {
            String num;
            while ((num = in.readLine()) != null && num.length() != 0) {
                int b = Integer.parseInt(num);
                int p = Integer.parseInt(in.readLine());
                int m = Integer.parseInt(in.readLine());
                String empty = in.readLine();
                int res = calculateBigMod(b, p, m);
                out.println(res);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    public static int calculateBigMod(int a, int b, int m) {
        if (b == 0)
            return 1;
        int x = calculateBigMod(a, b / 2, m);
        x = ((x % m) * (x % m)) % m;
        if (b % 2 == 1) {
            x = ((x % m) * (a % m)) % m;
        }
        return x;
    }
}