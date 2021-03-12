package algorithm.dp;
// 1,2,3 더하기 [11:55~12:16]


// 1) 1을 1,2,3의 합으로 나타내는 방법
// 1가지 : (1)
// 2) 2을 1,2,3의 합으로 나타내는 방법
// 2가지 : (1,1) / (2)
// 3) 3을 1,2,3의 합으로 나타내는 방법
// 4가지 : (1,2)/ (1,1,1) (2,1) / (3)
//
// 4) 4를 1,2,3의 합으로 나타내는 방법
// 7가지 : (1,3) / (1,1,2) (2,2) / (1,1,1,1) (1,2,1) (2,1,1) (3,1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9095__2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
