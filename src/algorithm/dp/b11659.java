package algorithm.dp;
// 구간 합 구하기 4
// 수 N개가 구어졌을 때, i번째부터 j번째 수까지 합을 구하는 프로그램
// 10만개의 수가 있을 때 10만번 범위를 계산한다면 : O(N^2)100_000_000_000 (천억)번
// 메모이제이션으로 연산값을 미리 저장해 두고 : 선택된 범위의 가장 큰 값 - 가장작은 값으로 합을 구해야 한다.
// O(N)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[end] - dp[start - 1]).append('\n'); ///
        }
        System.out.println(sb);
    }
}
