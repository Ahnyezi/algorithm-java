package algorithm.dp;
// 이친수
// N자리 이친수 개수
// - 0으로 시작 x, 11 부분문자열 x

// N == 1
// 1 -> 0만 가능
// [0,1]

// N == 2
// 10 -> 0,1 가능
// [1,0]

// N == 3
// 101 -> 0만 가능
// 100 -> 0,1 가능
// [1,1]

// N == 4
// 1010
// 1000
// 1001
// [2,1]

// N == 5
// 10100
// 10000
// 10010
// 10001
// 10101
// [3,2]

import java.util.Scanner;

public class b2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[2][2];
        dp[0][0] = 0; dp[0][1] = 1;

        for (int i = 1; i < N; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + dp[(i - 1) % 2][1];
            dp[i % 2][1] = dp[(i - 1) % 2][0];
            System.out.println(dp[i % 2][0]+","+dp[i % 2][1]);

        }

        System.out.println(dp[(N - 1) % 2][0] + dp[(N - 1) % 2][1]);
    }
}
