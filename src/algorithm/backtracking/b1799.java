package algorithm.backtracking;
// 비숍
// 체스판 크기 N <= 10
// 일반적으로 10x10 체스판에 체스를 놓는 방법 => 각 행에 체스 놓는 경우 (10)^(10행 개수) [10^10]
// queen은 각 행/열에서 1개만 올 수 있음 => 10!
// queen은 각 대각선에서 1개만 올 수 있음 => 더 줄어든다.

// 비숍을 칸에 놓을 수 있는 경우의 수 : 놓는다 / 놓지 않는다 2가지
// 비숍을 놓을 수 있는 칸의 수 : N * N
// 하지만 비숍은 대각선으로만 이동할 수 있으므로 흰/검 칸이 서로에게 영향을 미치지 않는다.
// 따라서 놓을 수 있는 칸의 수 : 흰 (N/2 * N/2) + 검 (N/2 * N/2)
// 10*10만큼 탐색하는 것을 5*5를 2번 탐색하는 것으로 줄일 수 있음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1799 {
    static BufferedReader br;
    static int N, cnt = 0;
    static int[][] board;
    static boolean[] right, left;

    // 시간초과
    static void solution1(){
        dfs(0);
        System.out.println(cnt);
    }
    static void dfs(int count) {
        // N^2만큼 탐색

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 || right[i + j] || left[i - j + N - 1])
                    continue;

                board[i][j] = 0;
                right[i + j] = true;
                left[i - j + N - 1] = true;
                dfs(count + 1);
                board[i][j] = 1;
                right[i + j] = false;
                left[i - j + N - 1] = false;
            }
        }
        cnt = Math.max(count, cnt);
    }

    static void solution2(){

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        right = new boolean[2 * N - 1];
        left = new boolean[2 * N - 1];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 놓을 수 있으면 1, 없으면 0

        solution1();
    }
}
