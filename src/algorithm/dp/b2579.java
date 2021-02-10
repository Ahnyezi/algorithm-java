package algorithm.dp;
// 계단오르기
// 1계단 or 2계단 가능, 연속 3개 불가능
// 시작점은 계단 x
// 마지막 반드시 밟기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
