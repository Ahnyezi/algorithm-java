package algorithm.search;
// 상범 빌딩

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b6593 {
    static char[][][] arr;
    static int[] start = null;
    static int[] end = null;
    static int[][][] visited;

    static boolean isRange(int x, int y, int z) {
        if (0 <= x && x < arr.length
                && 0 <= y && y < arr[0].length
                && 0 <= z && z < arr[0][0].length) {
            return true;
        }
        return false;
    }

    static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0][0].length; k++) {
                    System.out.print(visited[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    static String bfs() {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        visited = new int[arr.length][arr[0].length][arr[0][0].length];
        queue.add(start);
        visited[start[0]][start[1]][start[2]] = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                int nz = point[2] + dz[i];
                if (isRange(nx, ny, nz) && visited[nx][ny][nz] == 0
                        && (arr[nx][ny][nz] == '.' || arr[nx][ny][nz] == 'E')) {
                    visited[nx][ny][nz] = visited[point[0]][point[1]][point[2]] + 1;
                    queue.add(new int[]{nx, ny, nz});
                }
            }
            if (visited[end[0]][end[1]][end[2]] != 0)
                break;
        }

        if (visited[end[0]][end[1]][end[2]] == 0)
            return "Trapped!";
        return "Escaped in " + String.valueOf(visited[end[0]][end[1]][end[2]] - 1) + " minute(s).";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int floors = Integer.parseInt(st.nextToken());
            int n =Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (floors == 0 && n == 0 && m == 0) break;
            arr = new char[floors][n][m];
            start = null;
            end = null;

            for (int i = 0; i < floors; i++) {
                for (int j = 0; j < n; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < m; k++) {
                        arr[i][j][k] = s.charAt(k);
                        if (arr[i][j][k] == 'S') start = new int[]{i, j, k};
                        if (arr[i][j][k] == 'E') end = new int[]{i, j, k};
                    }
                }
                br.readLine();
            }

//            if (emptySpace == 0) {
//                System.out.println("Trapped!");
//                continue;
//            }

            System.out.println(bfs());
        }
    }
}
