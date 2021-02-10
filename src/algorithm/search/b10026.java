package algorithm.search;
// 적록색약

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b10026 {

    static String bfs(char[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 'R' && arr[i][j] != 'G' && arr[i][j] != 'B') continue;

                char cnt = Character.forDigit(++count, 10);
                char color = arr[i][j];

                queue.add(new int[]{i, j});
                arr[i][j] = cnt;

                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                                && arr[nx][ny] == color) {
                            queue.add(new int[]{nx, ny});
                            arr[nx][ny] = cnt;
                        }
                    }
                }
            }
        }

        // return Character.forDigit(count, 10); (오답)
        return String.valueOf(count);
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        char[][] arr2 = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
                arr2[i][j] = (arr[i][j] == 'G') ? 'R' : arr[i][j];
            }
        }
        System.out.println(bfs(arr) + " " + bfs(arr2));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
