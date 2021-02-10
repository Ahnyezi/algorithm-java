package algorithm.dp;
// 파도반 슈열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[100];
            dp[0] = dp[1] = dp[2] = 1;
            for (int j = 3; j < N; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[N - 1]);
        }
    }
}
