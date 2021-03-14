package algorithm.dp;

/* 계단 오르기
<규칙>
- 한 번에 1계단 or 2계단
- 연속 3계단 불가능
- 시작점은 계단 x
- 도착 계단 반드시 밟기

계단을 밟으면 해당 계단에 쓰인 점수를 얻을 수 있다고 할 때,
얻을 수 있는 점수의 최댓값은?

n번째 계단에 위치했다고 했을 때, 얻을 수 있는 점수의 최댓값?
- n - 2번째 계단을 밟은 뒤 n번째 계단을 밟았을 때 점수 (dp[n-2] + scores[n])
- n - 3번째 계단을 밟은 뒤 n-1번째 계단을 밟고 n번째 계단을 밟았을 때 점수 (dp[n-3] + scores[n-1] + scores[n])
다음의 두가지 경우를 구하여 더 큰 값으로 dp n방을 초기화한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2579__2 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= N; i++) {
            dp[i] = scores[i] = Integer.parseInt(br.readLine());
        }
        dp[2] += scores[1];

        for (int i = 3; i <= N; i++) {
            dp[i] += Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]);
        }

        System.out.println(dp[N]);
    }
}
