package algorithm.dp;
// 가장 큰 증가 부분 수열

import java.util.Scanner;
import java.util.StringTokenizer;

public class b11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            dp[i] = A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + A[i]){
                    dp[i] = dp[j] + A[i];
                }
            }
        }

        int max = 0;
        for (int num : dp) {
            if (max < num){
                max = num;
            }
        }
        System.out.println(max);
    }
}

// 5
// 1 2 9 4 9
