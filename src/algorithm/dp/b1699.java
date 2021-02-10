package algorithm.dp;
// 제곱수의 합
// n = 1
// 1개 (1 o)

// n == 2
// 1가지 방법 (1+1, 2 x)
// 최소 2

// n == 3
// 2가지 방법 (1+1+1, 1+2, 3 x) => 1만으로 dp[1] + 1,2로 dp[1]*dp[2]
// 최소 3

// n == 4
// 4가지 방법 (1+1+1+1, 1+3, 2+2, 4 o)
// => 1만으로 dp[1]
// => 1,3으로 dp[1] + dp[3]
// => 2,2로 dp[2] + dp[2]
// => 4로 1개
// 최소 1

// n == 5
// (1+1+1+1+1, 1+4, 2+3, 5 x)
// => 1만으로 dp[1]
// => 1,4로 dp[1] + dp[4]
// => 2,3으로 dp[2] + dp[3]

import java.util.Arrays;
import java.util.Scanner;

public class b1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[100_001];
        Arrays.fill(dp,Integer.MAX_VALUE);

        for (int i = 1; i <= Math.sqrt(N); i++) {
            dp[i * i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
