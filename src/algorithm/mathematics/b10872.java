package algorithm.mathematics;
// 팩토리얼

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10872 {
    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[13];

        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = i * dp[i - 1];
            System.out.print(dp[i]+" ");
        }
        System.out.println("\n"+dp[N]);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[13];
        System.out.println(dfs(N));
    }

    static long[] dp;

    static long dfs(int i) {
        if (dp[i] != 0)
            return dp[i];
        if (i < 2) {
            dp[i] = 1;
            return dp[i];
        }
        dp[i] = i * dfs(i - 1);
        return dp[i];
    }

    public static void main(String[] args) throws IOException {
        solution1();
    }
}
