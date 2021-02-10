package algorithm.dp;
// 오르막 수
// N 1000까지임 => 백트래킹하면 재귀깊이 1000까지 O(1000!)
// 오르막 수 : 0000_1222223_456_789

import java.util.Scanner;

public class b11057 {
    static int N;

    static void printArr(int[][] arr, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solution1() {
        if (N == 1) {
            System.out.println(10);
            return;
        }

        int[][] dp = new int[1000][11]; // ' '  + 0 ~ 9
        for (int i = 1; i < 11; i++) {
            dp[0][i] = 1; // 0 부터 9까지
        }

        long sum = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < 11; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10_007;// 여기 안해주면 long 범위 넘어가서 - 나올 수도
                System.out.println(dp[i][j]);
                if (i == N - 1)
                    sum += dp[i][j];
            }
        }

        System.out.println(sum % 10_007);
    }

    // 슬라이딩 윈도우
    static void solution2() {
        if (N == 1) {
            System.out.println(10);
            return;
        }

        int[] dp = new int[10]; // 어차피 i가 0이면 항상 1이다.
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }

        long sum = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < 10; j++) {
                dp[j] = (dp[j - 1] + dp[j]) % 10_007;
                if (i == N - 1) sum += dp[j];
            }
        }
        System.out.println(sum % 10_007);
    }

    // 재귀(Top-down)
    static void solution3() {
        long sum = 0;
        int[] dp = dfs(N);
        for (int num : dp) {
            sum += num;
        }
        System.out.println(sum % 10_007);
    }

    static int[] dfs(int depth) {
        int[] current = new int[10];
        if (depth == 1) {
            for (int i = 0; i < 10; i++) {
                current[i] = 1;
            }
            return current;
        }

        int[] before = dfs(depth - 1);
        current[0] = 1;
        for (int i = 1; i < 10; i++) {
            current[i] = (current[i - 1] + before[i]) % 10_007;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        solution3();
    }
}
