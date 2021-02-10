package algorithm.dp;
// 1,2,3 더하기
// 1만/ 2만/ 3만/ 1,2만/ 1,3만/ 2,3만/ 1,2,3다
// 방법의 수
// 1 => (1) 1가지
// 2 => (1,1), (2) 2가지
// 3 => (1,1,1), (2,1)/ (1,2) / (3) 4가지
// 4 => (1,1,1,1), (2,1,1), (1,2,1), (3,1) / (1,3) / (1,1,2), (2,2) 7가지 ===> dp[3]에다가 1더한 거 + dp[2]에다가 2더한거 + dp[1]에다가 3더한거
// 5 => (1,1,1,1,1), (2,1,1,1), (1,2,1,1), (3,1,1), (1,3,1), (1,1,2), (2,2,1) / (1,1,3), (2,3) / (1,1,1,2), (2,1,2), (1,2,2), (3,2)
// dp[n] = dp[n-1] + dp[n-2] + dp[n-3];

import java.util.Scanner;

public class b9095 {
    static Scanner sc;

    static void solution1(){
        int[] dp = new int[10]; // 주의
        dp[0] = 1; dp[1] = 2; dp[2] = 4;
        for (int i = 3; i < 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(dp[n - 1]);
        }
    }

    // 더 빠름
    static int count = 0;
    static void solution2(){
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            dp(Integer.parseInt(sc.nextLine()));
            System.out.println(count);
            count = 0;
        }
    }

    static void dp(int num){
        if (num < 0)
            return;
        if (num == 0){
            count++;
            return;
        }

        dp(num - 1);
        dp(num - 2);
        dp(num - 3);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
//        solution1();
        solution2();
    }
}
