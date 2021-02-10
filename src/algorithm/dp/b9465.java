package algorithm.dp;
// 스티커

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class b9465 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(sc.nextLine());
        while (t-- != 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] s1 = sc.nextLine().split(" ");
            String[] s2 = sc.nextLine().split(" ");

            int[][] score = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[0][i] = score[0][i] = Integer.parseInt(s1[i - 1]);
                dp[1][i] = score[1][i] = Integer.parseInt(s2[i - 1]);
            }

            for (int i = 2; i <= n; i++) {// check
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            bw.write(Math.max(dp[0][n], dp[1][n])+"\n");
            bw.flush();
        }
        bw.close();
    }
}
