package algorithm.dp;
/* 1로 만들기

가능한 연산은 3가지이다.
- X/=3
- X/=2
- X-=1

연산순서에 따라서 결과가 달지고, 연산 횟수의 최소값을 구해야하므로
모든 경우의 수를 따져야 한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1463__2 {

    public static void main(String[] args) throws IOException {
        solution1();
    }

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        for (int i = 2; i <= X; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 2; i <= X; i++) {
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i])
                dp[i] = dp[i / 3] + 1;
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i])
                dp[i] = dp[i / 2] + 1;
            if (dp[i - 1] + 1 < dp[i])
                dp[i] = dp[i - 1] + 1;
        }

        System.out.println(dp[X]);
    }
}
