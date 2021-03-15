package algorithm.dp;
/* RGB거리 [11:28~]

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class b1149 {

    // 일반 dp
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Arrays.stream(dp[N - 1]).min().getAsInt());
    }

    // 슬라이딩 윈도우
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[2][3];
        dp[0][0] = costs[0][0]; dp[0][1] = costs[0][1]; dp[0][2] = costs[0][2];
        for (int i = 1; i < N; i++) {
            dp[i % 2][0] = costs[i][0] + Math.min(dp[(i + 1) % 2][1], dp[(i + 1) % 2][2]);
            dp[i % 2][1] = costs[i][1] + Math.min(dp[(i + 1) % 2][0], dp[(i + 1) % 2][2]);
            dp[i % 2][2] = costs[i][2] + Math.min(dp[(i + 1) % 2][0], dp[(i + 1) % 2][1]);
        }

        System.out.println(Arrays.stream(dp[(N - 1) % 2]).min().getAsInt());
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
