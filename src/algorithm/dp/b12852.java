package algorithm.dp;
/* 1로 만들기 2
 10^6 >= N >= 1
 연산 횟수의 최솟값과 만드는 방법에 포함된 수 출력

풀이
최소 횟수를 담을 배열 int dp[]
최소 횟수의 구성 요소를 담을 리스트 Map<Integer, ArrayList<Integer>> : key(dp의 index)

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class b12852 {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X + 1]; // 0: 0, 1:0, 2:1, 3:1
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;

        HashMap<Integer, ArrayList<Integer>> nums = new HashMap<>();
        for (int i = 1; i <= X; i++) {
            nums.put(i, new ArrayList<>());
            nums.get(i).add(i);
        }

        for (int i = 2; i <= X; i++) {
            int min = 1;

            if (i % 3 == 0) {
                dp[i] = dp[i / 3] + 1;
            }
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                min = 2;
            }
            if (dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                min = 3;
            }

            switch (min) {
                case 1:
                    for (Integer num : nums.get(i / 3)) {
                        nums.get(i).add(num);
                    }
                    break;
                case 2:
                    for (Integer num : nums.get(i / 2)) {
                        nums.get(i).add(num);
                    }
                    break;
                case 3:
                    for (Integer num : nums.get(i - 1)) {
                        nums.get(i).add(num);
                    }
            }
        }

        sb.append(dp[X]).append('\n');
        for (Integer num : nums.get(X)) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }


    static StringBuilder sb;
    static int[] pre;
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        pre = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            if (i < 4) {
                dp[i] = pre[i] = 1;
                continue;
            }

            dp[i] = dp[i - 1] + 1;
            pre[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                pre[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                pre[i] = i / 3;
            }
        }

        sb.append(dp[N]).append('\n');
        dfs(N);
        System.out.println(sb);
    }

    static void dfs(int i){
        if (i == 0) return;
        sb.append(i).append(' ');
        dfs(pre[i]);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
