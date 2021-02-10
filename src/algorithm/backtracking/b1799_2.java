package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비숍
// https://jaejin89.tistory.com/49

public class b1799_2 {
    static int N;
    static int[][] board;
    static boolean[][] visited, isBlack;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        isBlack = new boolean[N][N];
        ans = new int[2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                isBlack[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0);
            }
        }

        dfs(-1, true, 0);
        dfs(-1, false, 0);

        System.out.println(ans[0] + ans[1]);
    }

    static void dfs(int index, boolean black, int cnt) {

        for (int i = index + 1; i < N * N; i++) {
            int x = i / N;
            int y = i % N;

            if (board[x][y] == 0 || isBlack[x][y] != black || !check(x, y))
                continue;

            visited[x][y] = true;
            dfs(i, black, cnt + 1);
            visited[x][y] = false;
        }

        ans[black ? 0 : 1] = Math.max(cnt, ans[black ? 0 : 1]);
    }

    static boolean check(int x, int y) {
        // 0행에서 밑으로 내려오기 때문에 현재 칸 위쪽만 체크
        int[] dx = {-1, -1};
        int[] dy = {-1, 1};

        for (int i = 0; i < 2; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)//?????
                    break;
                if (visited[nx][ny])
                    return false;
                nx += dx[i];
                ny += dy[i];
            }
        }
        return true;
    }

}
