package algorithm.dp;
/* 피보나치 함수
주어지는 수의 범위: 1 <= n <= 40
문제에서 요구하는 바를 재귀로 구현하게 되면
40 level의 트리가 만들어지게 되고 O(40!)이라는 시간 복잡도가 나오게된다. (0.25초 안에 당연히 통과 불가)
따라서 만들어질 수 있는 수들의 규칙을 찾아서 점화식을 만들어야 한다.
N = 0
1 0
N = 1
0 1
N = 2
1 1
N = 3
2 1

위의 숫자를 토대로 0의 개수, 1의 개수를 각각 담는 DP 배열을 만들 수 있다.
   N       0   1   2   3   4   5
[0의 개수]  1   0   1   1   2
[1의 개수]  0   1   1   2   3

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[41][2];
        dp[0][0] = dp[1][1] = 1;
        dp[0][1] = dp[1][0] = 0;
        for (int i = 2; i < 41; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][0]).append(' ').append(dp[num][1]).append('\n');
        }
        System.out.println(sb);
    }
}
