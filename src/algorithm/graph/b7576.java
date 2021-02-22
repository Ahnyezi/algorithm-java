package algorithm.graph;
// 토마토
// 처음부터 익어있는 상태면 0
// 익을 수 없으면 -1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7576 {
    static int UNRIPE = 0, RIPE = 1;
    static int M, N, unripe_cnt;
    static int[][] box;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        unripe_cnt = 0;

        box = new int[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == UNRIPE) unripe_cnt++;
                else if (box[i][j] == RIPE) queue.add(new Point(i, j, 0));
            }
        }

        if (unripe_cnt == 0) {
            System.out.println(0);
            return;
        }

        int result = bfs();
        if (unripe_cnt > 0)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    static int bfs() {
        int maxDay = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            maxDay = curr.days + 1;

            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (isRange(nx, ny) && box[nx][ny] == UNRIPE) {
                    queue.add(new Point(nx, ny, maxDay));
                    box[nx][ny] = maxDay;
                    unripe_cnt--;
                }
            }

        }// end of while

        return maxDay - 1;
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M)
            return false;
        return true;
    }

    static class Point {
        int x, y, days;

        public Point(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }
}
