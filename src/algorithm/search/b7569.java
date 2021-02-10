package algorithm.search;
// 토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7569 {
    static Queue<int[]> queue = new LinkedList<>();
    static int[][][] arr;
    static int zeros;

    static int bfs2() {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        int max = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                int nz = point[2] + dz[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length && 0 <= nz
                        && nz < arr[0][0].length && arr[nx][ny][nz] == 0) {
                    max = arr[nx][ny][nz] = arr[point[0]][point[1]][point[2]] + 1;
                    zeros--;
                    queue.add(new int[]{nx, ny, nz});
                }
            }
        }
        return max;
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int h = Integer.parseInt(st.nextToken()); // 높이
        arr = new int[h][n][m];
        zeros = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0) zeros++;
                    if (arr[i][j][k] == 1) queue.add(new int[]{i, j, k});
                }
            }
        }
        if (zeros == 0) {
            System.out.println(0);
            return;
        }
        int res = bfs2();
        if (zeros > 0) System.out.println(-1);
        else System.out.println(res - 1);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }

    static int bfs(int x, int y, int z) {
        boolean[][][] visited = new boolean[arr.length][arr[0].length][arr[0][0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        queue.add(new int[]{x, y, z});
        int max = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                int nz = point[2] + dz[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length && 0 <= nz && nz < arr[0][0].length
                        && !visited[nx][ny][nz] && (arr[nx][ny][nz] == 0 || arr[nx][ny][nz] > 1)) {
                    if (arr[nx][ny][nz] == 0) {
                        arr[nx][ny][nz] = arr[point[0]][point[1]][point[2]] + 1;
                        zeros--;
                    } else arr[nx][ny][nz] = Math.min(arr[nx][ny][nz], arr[point[0]][point[1]][point[2]] + 1);
                    max = Math.max(arr[nx][ny][nz], max);
                    queue.add(new int[]{nx, ny, nz});
                    visited[nx][ny][nz] = true;
                }
            }
        }
        return max;
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int h = Integer.parseInt(st.nextToken()); // 높이
        arr = new int[h][n][m];
        zeros = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 0) zeros++;
                }
            }
        }
        if (zeros == 0) {
            System.out.println(0);
            return;
        }

        int min = 1000001;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 1) {
                        min = Math.min(bfs(i, j, k), min);
                    }
                }
            }
        }
        if (zeros > 0) System.out.println(-1);
        else System.out.println(min - 1);
    }


}

// for (int i = 0; i < h; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < m; k++) {
//                    System.out.print(arr[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//        }