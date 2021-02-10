package algorithm.dp;
// 가장 긴 감소하는 부분 수열

import java.util.Scanner;
import java.util.StringTokenizer;

public class b11722 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = N - 1; i >= 0 ; i--) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}
