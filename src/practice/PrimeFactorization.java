package practice;

import java.io.*;

/**
 * @author: Pial Kanti Samadder <pialkanti2012@gmail.com>
 * Date: 4/29/2018
 * Time: 10:02 PM
 */
public class PrimeFactorization {
    static int[] least_pf;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        try {
            int num = Integer.parseInt(in.readLine());
            least_pf = calculateLPF(num);
            out.print("Least Prime Factors:");
            while (num > 1) {
                out.print(" " + least_pf[num]);
                num /= least_pf[num];
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    //calculate least prime factor for all numbers upto n
    public static int[] calculateLPF(int n) {
        int[] lpf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            lpf[i] = 0;
        }
        lpf[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (lpf[i] == 0) {
                lpf[i] = i;

                for (int j = i * 2; j <= n; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }

        return lpf;
    }
}
