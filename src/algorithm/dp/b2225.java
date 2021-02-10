package algorithm.dp;

import java.util.Scanner;
import java.util.StringTokenizer;

// 합분해
public class b2225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int MOD = 1_000_000_000;
        int[][] dp = new int[2][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= K ; i++) {
            dp[i % 2][0] = 1;
            for (int j = 1; j <= N ; j++) {
                dp[i % 2][j] = (dp[(i - 1) % 2][j] + dp[i % 2][j - 1]) % MOD;
            }
        }
        System.out.println(dp[K % 2][N] % MOD);
    }
}
