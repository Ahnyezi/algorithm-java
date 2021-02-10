package algorithm.backtracking;

import java.util.Scanner;

public class b9663_3 {
    static int N, cnt = 0;
    static boolean[] col, right, left;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new boolean[N];
        right = new boolean[2 * N - 1];
        left = new boolean[2 * N - 1];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (col[i] || right[i + row] || left[i - row + N - 1])
                continue;

            col[i] = true;
            right[i + row] = true;
            left[i - row + N - 1] = true;
            dfs(row + 1);
            col[i] = false;
            right[i + row] = false;
            left[i - row + N - 1] = false;
        }
    }
}
