package algorithm.dp;
// 타일 채우기

import java.util.Scanner;

public class b2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[31];

        dp[2] = 3;
        for (int i = 4; i <= N ; i++) {
            if (i % 2 == 1) continue;

            dp[i] = dp[2] * (dp[i - 2]) + 2;
            for (int j = 4; j < i ; j += 2) {
                dp[i] += 2 * dp[i - j];
            }
        }

        System.out.println(dp[N]);
    }
}

// N == 4
// (N 2) * (N 2) + N 4 고유(2)
// 9 + 2
// N == 6
// (N 2) * (N 4) + (N 4 고유) * (N 2) + N 6 고유 2
// N == 8
// (N 2) * (N 6) + (N 4 고유) * (N 4) + (N 6 고유) * (N 2) + N 8 고유 2
// N == 10
// (N 2) * (N 8) + (N 4 고유) * (N 6) + (N 6 고유) * (N 4) + (N 8 고유) * (N 2) + N 10 고유 2
// N == K
// (N 2) * (N K - 2) + 2 * (N K - 4) + 2 * (N K - 6) + ...2 * (N K - (K - 2)) + N K 고유 2


