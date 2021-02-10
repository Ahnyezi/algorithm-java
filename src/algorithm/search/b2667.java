package algorithm.search;
// 단지 번호 붙이기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2667 {
    static int[][] arr;

    static int bfs(int x, int y, int cnt) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = cnt;

        int houses = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny
                        && ny < arr[0].length && arr[nx][ny] == 1) {
                    arr[nx][ny] = cnt;
                    queue.add(new int[]{nx, ny});
                    houses++;
                }
            }
        }

        return houses;
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                arr[i][j++] = c - '0';
            }
        }

        int cnt = 1;
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    res.add(bfs(i, j, ++cnt));
                }
            }
        }
        Collections.sort(res);

        System.out.println(cnt - 1);
        for (int r : res) {
            System.out.println(r);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
