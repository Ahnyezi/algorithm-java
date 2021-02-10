package algorithm.dp;
// 포도주 시식
// 잔을 선택하면 다 마신다.
// 연속 3잔 마실 수 없다. => dp
// 6, 10, 13, 9, 8 1
// n == 1 : 6
// n == 2 : 6, 10
// n == 3 : 13, 6 / 10 , 6
// n == 4 :
// dp[n] = Math.max(dp[n-2] + wines[i], dp[n-1], + ....)

// 주의!! 마지막 값 거쳐야 하는가를 살펴라
//10, 25, 30, 1 이 차례대로 있고, 2개를 초과하여 연속으로 뽑을 수 없을 때 마지막 숫자를 반드시 거쳐야 하는 경우와 그런 조건이 없는 경우 누적 합의 최댓값은 다음과 같이 달라진다.
//<마지막 숫자(1)를 반드시 거쳐야 하는경우>
//10, 30, 1 → 누적합 : 41
//<위 조건이 없는 경우>
//25, 30 → 누적합 : 55

import java.util.Scanner;

public class b2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] wines = new int[10001]; // 주의1
        int[] dp = new int[10001];
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(sc.nextLine());
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        // 얘 때매 틀렷스
        // 어차피 0번방은 0이기 때문
        // 주의2
//        dp[2] = Math.max(wines[0] + wines[2], Math.max(wines[0] + wines[1], wines[1] + wines[2]));

        if (n <= 2){
            System.out.println(dp[n]);
            return;
        }

        // 주의3
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + wines[i - 1] + wines[i], Math.max(dp[i - 2] + wines[i], dp[i - 1]));
        }
        System.out.println(dp[n]);
    }
}
