package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1600_2 {
    static int[][][] arr;

    static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int k, x, y;

        Point(int k, int x, int y) {
            this.k = k;
            this.x = x;
            this.y = y;
        }
    }

    static boolean isRange(int x, int y) {
        if (0 <= x && x < arr[0].length
                && 0 <= y && y < arr[0][0].length) {
            return true;
        }
        return false;
    }

    static int bfs(int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (isRange(nx, ny) && arr[point.k][nx][ny] == 0) {
                    queue.add(new Point(point.k, nx, ny));
                    arr[point.k][nx][ny] = arr[point.k][point.x][point.y] + 1;
                }
            }

            for (int i = 0; i < 8; i++) {
                int nx = point.x + hx[i];
                int ny = point.y + hy[i];
                if (isRange(nx, ny) && point.k + 1 <= k && arr[point.k + 1][nx][ny] == 0) {
                    queue.add(new Point(point.k + 1, nx, ny));
                    arr[point.k + 1][nx][ny] = arr[point.k][point.x][point.y] + 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k + 1; i++) {
            int tmp = arr[i][arr[0].length - 1][arr[0][0].length - 1];
            if (tmp == 0) continue;
            min = Math.min(min, tmp);
        }

        if (min == Integer.MAX_VALUE) return -1;
        return min - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        arr = new int[k + 1][h][w];

        // null pointer exception (4x5...)
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[0][i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr[0][0][0] = 1; //

        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < h; j++) {
                for (int l = 0; l < w; l++) {
                    arr[i][j][l] = arr[0][j][l];
                }
            }
        }

        System.out.println(bfs(k));
    }
}

