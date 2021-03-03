package algorithm.graph;
// 미로 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 {
    static int N, M;
    static int[][] map;
    static int AVAILABLE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(BFS());
    }

    static int BFS() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        map[0][0] = 2;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (isRange(nx, ny) && map[nx][ny] == AVAILABLE) {
                    queue.add(new int[]{nx, ny});
                    map[nx][ny] = map[point[0]][point[1]] + 1;
                }
            }
            if (map[N - 1][M - 1] != AVAILABLE)
                break;
        }

        return map[N - 1][M - 1] - 1;
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M)
            return false;
        return true;
    }
}
