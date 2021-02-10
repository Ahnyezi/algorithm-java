package algorithm.search;
// 그림 (너비 우선)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1926 {
    static int[][] arr;

    static int bfs(int x, int y) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        arr[x][y] = 0; // 방문 체크를 위한 초기화
        int cnt = 1;   // 그림개수 계산을 위한 변수

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny
                        && ny < arr[0].length && arr[nx][ny] == 1) {
                    arr[nx][ny] = ++cnt; // 그림 누적개수 계산하여 변수에 삽입
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }

    static void solution() throws IOException {
        // bfs
        // 49220kb	496ms
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                    max = Math.max(max, bfs(i, j)); // 가장 큰 그림 크기로 초기화
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
