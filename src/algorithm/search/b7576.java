package algorithm.search;
// 토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b7576 {
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] arr;
    static int zeros;

    public static void main(String[] args) throws IOException {
        solution3();
    }

    static void solution3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        zeros = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) zeros++;
                if (arr[i][j] == 1) queue.add(new int[]{i, j});
            }
        }
        if (zeros == 0) {
            System.out.println(0);
            return;
        }

        int res = bfs3();
        if (zeros > 0) System.out.println(-1);
        else System.out.println(res - 1);
    }

    static int bfs3() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int max = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny] == 0) {
                    max = arr[nx][ny] = arr[point[0]][point[1]] + 1;
                    zeros--;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return max;
    }

    static int bfs2(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int max = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny] != -1 && visited[nx][ny] == false) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[point[0]][point[1]] + 1;
                        zeros--;
                    } else arr[nx][ny] = Math.min(arr[point[0]][point[1]] + 1, arr[nx][ny]);
                    max = Math.max(arr[nx][ny], max);
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return max;
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        zeros = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) zeros++;
            }
        }

        int min = 1000001;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    min = Math.min(bfs2(i, j), min);
                }
            }
        }

        if (zeros > 0) System.out.println(-1);
        else if (min == 0) System.out.println(0); // 이미 완료된 상태
        else System.out.println(min - 1);
    }

    static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int max = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny] != -1 && visited[nx][ny] == false) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[point[0]][point[1]] + 1;
                        zeros--;
                    } else arr[nx][ny] = Math.min(arr[point[0]][point[1]] + 1, arr[nx][ny]);
                    max = Math.max(arr[nx][ny], max);
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[0].length; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }
        return max;
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        zeros = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) zeros++;
            }
        }

        int min = 1000001;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    min = Math.min(bfs(i, j), min);
                }
            }
        }

        int max = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(arr[i][j], max);
                if (arr[i][j] == 0) flag = true;
            }
        }

        if (flag) System.out.println(-1);
        else System.out.println(max - 1);

    }


}
