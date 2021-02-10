package algorithm.backtracking;
// 1.2초 1억번
// 12초 10억번

// *중요*
// 1. cnt 구하는 법(cnt를 지역변수로)
// 2. index로 x,y좌표 만드는 법(int index와 N*N)
// 3. 검/흰 구별하는 법 (isBlack 배열과 black 변수)
// 4. 위쪽 대각선과 현재 위치 체크하는 법

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1799_3 {
    static int N;
    static int[] res;
    static int[][] board;
    static boolean[][] visited, isBlack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        res = new int[2];
        board = new int[N][N];
        visited = new boolean[N][N];
        isBlack = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                isBlack[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
            }
        }

        dfs(0,true,0);
        dfs(0,false,0);
        System.out.println(res[0] + res[1]);
    }

    static void dfs(int index, boolean black, int cnt) {

        for (int i = index; i < N * N; i++) {
            int x = i / N;
            int y = i % N;

            if (board[x][y] == 0 || isBlack[x][y] != black || !check(x, y))
                continue;

            visited[x][y] = true;
            dfs(i + 1, black, cnt + 1);
            visited[x][y] = false;
        }

        res[black ? 0 : 1] = Math.max(res[black ? 0 : 1], cnt);
    }

    // 현재 위치  +  대각선 체크
    static boolean check(int x, int y) {
        int[] dx = {-1,-1};
        int[] dy = {-1,1};

        for (int i = 0; i < 2; i++){
//        for (int[] point : new int[][]{{-1, -1}, {-1, 1}}) {
            int nx = x;
            int ny = y;
            while (true) {
                if (0 > nx || nx >= N || 0 > ny || ny >= N)
                    break;
                if (visited[nx][ny])
                    return false;

                nx += dx[i];
                ny += dy[i];
//                nx += point[0];
//                ny += point[1];
            }
        }
        return true;
    }
}
