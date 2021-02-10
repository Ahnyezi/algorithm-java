package algorithm.backtracking;
// n-queen

import java.util.Scanner;

public class b9663 {
    static int n;
    static int cnt = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[row] = i;
            if (isPossible(row)) {
                dfs(row + 1);
            }
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 열 검사
            if (arr[i] == arr[row]) {
                return false;
            }
            // 대각선 검사
            if (Math.abs(i - row) == Math.abs(arr[i] - arr[row])) {
                return false;
            }
        }
        return true;
    }
}
