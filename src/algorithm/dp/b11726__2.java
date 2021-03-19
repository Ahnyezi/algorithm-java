package algorithm.dp;

/* 2 x n 타일링
 2 x n 크기의 직사각형을 채워라
- 사용할 수 있는 타일의 크기
   - 1 x 2
   - 2 x 1

- 풀이
- dp[i]는 2가지 타일을 사용해서 2 x i 직사각형을 채울 수 있는 방법의 수이다.
- 2 x i를 만들 수 있는 경우의 수는 다음의 두 경우를 더한 값이다.
   - 2 x (i - 1)까지 만든 타일 + [2x1타일]
   - 2 x (i - 2)까지 만든 타일 + [1x2타일+1x2타일]
- 이것을 점화식으로 나타내면, dp[i] = dp[i-1] + dp[i-2]

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11726__2 {
    static int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];

        System.out.println(recursion(N, dp));
    }

    public static long recursion(int n, long[] dp) {
        if (dp[n] != 0)
            return dp[n];
        if (n <= 2)
            return dp[n] = n;
        return dp[n] = (recursion(n - 1, dp) % MOD + recursion(n - 2, dp) % MOD) % MOD;
    }
}
