package algorithm.search;
// 미로탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178 {
    static int[][] arr;

    static int bfs(int x, int y) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny
                        && ny < arr[0].length && arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[point[0]][point[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }

    static void solution() throws IOException {// 최단거리 (bfs)
        // 15036kb 136ms
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
