package algorithm.dp;
// 가장 긴 바이토닉 부분 수열

import java.util.Scanner;

public class b11054 {
    static int N;
    static int[] A, dp1, dp2;

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        A = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];

        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(s[i]);
        }

        dp1[0] = 1;
        for (int i = 0; i < N; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp1[i] <= dp1[j]){
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        dp2[N - 1] = 1;
        for (int i = N - 2; i >= 0 ; i--) {
            dp2[i] = 1;
            for (int j = N - 1; j > i ; j--) {
                if (A[i] > A[j] && dp2[i] <= dp2[j]){
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        int max = dp1[0] + dp2[0];
        for (int i = 1; i < N; i++) {
            if (max < dp1[i] + dp2[i])
                max = dp1[i] + dp2[i];
        }
        System.out.println(max - 1);
    }
}
