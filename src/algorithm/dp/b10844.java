package algorithm.dp;
// 쉬운 계단 수
// 2차원 배열로 만든다.

import java.util.Scanner;

public class b10844 {
    static Scanner sc;
    static int N;
    static int mod = 1_000_000_000;

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // bottom-up
    static void solution1() {
        int[][] dp = new int[N + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i + 1][j + 1] += dp[i][j] % mod;
                } else if (j == 9) {
                    dp[i + 1][j - 1] += dp[i][j] % mod;
                } else {
                    dp[i + 1][j - 1] += dp[i][j] % mod;
                    dp[i + 1][j + 1] += dp[i][j] % mod;
                }
            }
        }

        long sum = 0;
        for (int n : dp[N]) {
            sum += n % mod;
        }
        System.out.println(sum % mod);
    }


    static void solution2() {
        int[][] dp = new int[101][11]; // 9 처리를 위한 1칸 추가
        int mod = 1_000_000_000;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        long sum = 0;
        for (int n : dp[N]) {
            sum += n;
        }
        System.out.println(sum % mod);
    }

    // 슬라이딩 윈도우 - 1
    static void solution3(){
        int[][] dp = new int[2][11];

        if(N == 1){
            System.out.println(9);
            return;
        }

        for (int i = 1; i < 10; i++) { // 1
            dp[0][i] = 1;
        }

        for (int i = 2; i <= N; i++) {// 2 ~ N (N - 1번)
            dp[1][0] = dp[0][1];
            for (int j = 1; j < 10; j++) {
                dp[1][j] = (dp[0][j - 1] + dp[0][j + 1]) % mod;
            }
            for (int j = 0; j < 10; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        long sum = 0;
        for (int n : dp[1]) {
            sum += n;
        }
        System.out.println(sum % mod);
    }

    static void solution4(){
        if (N == 1){
            System.out.println(9);
            return;
        }

        int[][] dp = new int[2][11];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i % 2][0] = dp[(i - 1) % 2][1];
            for (int j = 1; j < 10; j++) {
                dp[i % 2][j] = (dp[(i - 1) % 2][j - 1]
                        + dp[(i - 1) % 2][j + 1]) % mod;
            }
        }

        long sum = 0;
        for (int num : dp[N % 2]) {
            sum += num;
        }
        System.out.println(sum % mod);
    }


    public static void main(String[] args) {
        sc = new Scanner(System.in);
        N = sc.nextInt();
//        solution2();
        solution4();
    }
}
